package my.projects.myfinance.service;

import my.projects.myfinance.dto.AccountDto;
import my.projects.myfinance.dto.AccountRequestDto;
import my.projects.myfinance.model.*;
import my.projects.myfinance.repo.AccountBalanceRepo;
import my.projects.myfinance.repo.AccountRepo;
import my.projects.myfinance.repo.AccountTypeRepo;
import my.projects.myfinance.repo.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AccountService {

    final AccountRepo accountRepo;
    final IconRepo iconRepo;
    final AccountTypeRepo atRepo;
    final AccountBalanceRepo accountBalanceRepo;
    final UserService userService;
    final TransactionService transactionService;

    @Autowired
    public AccountService(AccountRepo accountRepo,
                          IconRepo iconRepo,
                          AccountTypeRepo atRepo,
                          AccountBalanceRepo accountBalanceRepo,
                          UserService userService,
                          TransactionService transactionService) {
        this.accountRepo = accountRepo;
        this.iconRepo = iconRepo;
        this.atRepo = atRepo;
        this.accountBalanceRepo = accountBalanceRepo;
        this.userService = userService;
        this.transactionService = transactionService;
    }

    public Account getAccount(Long accountId) {
        return accountRepo.findFirstByIdAndUserId(
                accountId, userService.getCurrentUserId());
    }

    public Account getAccount(String accountName) {
        return accountRepo.findFirstByNameAndUserId(accountName, userService.getCurrentUserId());
    }

    public List<AccountDto> getAccounts(String month) {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        String finalMonth = month != null ? month :
                String.format("%4d%2d", today.get(Calendar.YEAR), today.get(Calendar.MONTH) + 1);
        return accountRepo.getAccountByUserId(userService.getCurrentUserId())
                .stream().map(account -> {
                    AccountBalance balance = accountBalanceRepo.findFirstByAccountIdAndMonth(
                            account.getId(), finalMonth);
                    return new AccountDto()
                            .setId(account.getId())
                            .setName(account.getName())
                            .setValue(balance != null ? balance.getValueBefore() : 0)
                            .setLimit(account.getLimit())
                            .setIcon(account.getIconObject().getValue())
                            .setCurrency(account.getCurrencyObject().getShortName())
                            .setType(account.getAccountType().getValue())
                            .setCreationDate(account.getCreationDate())
                            .setExpirationDate(account.getExpirationDate());
                })
                .collect(Collectors.toList());
    }

    public Long addAccount(AccountRequestDto request) {
        Icon icon = iconRepo.findFirstByValue(request.getIcon());
        AccountType at = atRepo.findFirstByValue(request.getType());
        if (icon != null && at != null) {
            Account account = new Account()
                    .setName(request.getName())
                    .setValue(0L)
                    .setLimit(request.getLimit() == null ? 0 : request.getLimit())
                    .setIcon(icon.getId())
                    .setCurrency(1)
                    .setType(at.getId())
                    .setCreationDate(new Timestamp(System.currentTimeMillis()))
                    .setUserId(userService.getCurrentUserId());
            return accountRepo.save(account).getId();
        }
        return -1L;
    }

    public Long editAccount(AccountRequestDto request) {
        Account account = this.getAccount(request.getId());
        Icon icon = iconRepo.findFirstByValue(request.getIcon());
        AccountType at = atRepo.findFirstByValue(request.getType());
        if (account != null && icon != null && at != null) {
            account.setName(request.getName())
                    .setIcon(icon.getId())
                    .setType(at.getId())
                    .setLimit(request.getLimit())
                    .setUpdateDate(new Timestamp(System.currentTimeMillis()));
            return accountRepo.save(account).getId();
        }
        return -1L;
    }

    public Long softDeleteAccount(AccountRequestDto request) {
        Account account = this.getAccount(request.getId());
        if (account != null) {
            account.setExpirationDate(new Timestamp(System.currentTimeMillis()));
            return accountRepo.save(account).getId();
        }
        return -1L;
    }

    public Integer calculateAllBalances() {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) return -1;
        Calendar date = Calendar.getInstance();
        List<Account> accounts = accountRepo.getAccountByUserId(userService.getCurrentUserId());
        if (accounts == null) return -2;
        date.setTime(currentUser.getCreationDate());
        accounts.stream()
                .filter(account -> account.getAccountType().getValue().equals("account-asset"))
                .forEach(this::calculateBalance);
        return 1;
    }

    public void calculateBalance(Account account) {
        Calendar creationDate = Calendar.getInstance();
        Calendar finishDate = Calendar.getInstance();
        Calendar transactionDate = Calendar.getInstance();
        finishDate.setTime(new Date());
        finishDate.set(Calendar.DAY_OF_MONTH, 1);
        List<Transaction> transactions = transactionService.getTransactions(account.getId().intValue());
        if (transactions != null) {
            Map<Integer, Long> debitResult = transactions.stream()
                    .collect(Collectors.groupingBy(transaction -> {
                        transactionDate.setTime(transaction.getDate());
                        return getMonthYear(transactionDate);
                    }, Collectors.summingLong(transaction -> transaction.getSourceId() == account.getId()
                            ? -transaction.getSourceValue()
                            : transaction.getDestinationValue())));
            creationDate.setTime(account.getCreationDate());
            creationDate.set(Calendar.DAY_OF_MONTH, 1);
            Long valueBefore = account.getValue();
            while (getMonthYear(creationDate) <= getMonthYear(finishDate)) {
                Long value = debitResult.get(getMonthYear(creationDate));
                value = value == null ? 0 : value;
                addOrUpdateBalance(account.getId(),
                        getMonthYear(creationDate) + "",
                        valueBefore, value);
                valueBefore += value;
                creationDate.set(Calendar.MONTH, creationDate.get(Calendar.MONTH) + 1);
            }
        }
    }

    private Integer getMonthYear(Calendar calendar) {
        return calendar.get(Calendar.YEAR) * 100 + calendar.get(Calendar.MONTH) + 1;
    }

    public void addOrUpdateBalance(Long accountId, String month, Long valueBefore, Long value) {
        AccountBalance balance = accountBalanceRepo.findFirstByAccountIdAndMonth(accountId, month);
        if (balance != null) {
            accountBalanceRepo.save(balance
                    .setValueBefore(valueBefore)
                    .setValueChange(value)
                    .setValueAfter(valueBefore + value)
                    .setUpdateDate(new Timestamp(System.currentTimeMillis())));
        } else {
            accountBalanceRepo.save(new AccountBalance()
                    .setAccountId(accountId)
                    .setMonth(month)
                    .setValueBefore(valueBefore)
                    .setValueChange(value)
                    .setValueAfter(valueBefore + value)
                    .setUpdateDate(new Timestamp(System.currentTimeMillis())));
        }
    }
}
