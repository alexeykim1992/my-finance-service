package my.projects.myfinance.service;

import my.projects.myfinance.dto.AccountDto;
import my.projects.myfinance.dto.AccountRequestDto;
import my.projects.myfinance.model.Account;
import my.projects.myfinance.model.AccountType;
import my.projects.myfinance.model.Icon;
import my.projects.myfinance.repo.AccountRepo;
import my.projects.myfinance.repo.AccountTypeRepo;
import my.projects.myfinance.repo.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    IconRepo iconRepo;
    @Autowired
    AccountTypeRepo atRepo;
    @Autowired
    UserService userService;

    public Account getAccount(Long accountId) {
        return accountRepo.findFirstByIdAndUserId(
                accountId, userService.getCurrentUserId());
    }

    public List<AccountDto> getAccounts() {
        return accountRepo.getAccountByUserId(userService.getCurrentUserId())
                .stream().map(account -> new AccountDto()
                        .setId(account.getId())
                        .setName(account.getName())
                        .setValue(account.getValue())
                        .setLimit(account.getLimit())
                        .setIcon(account.getIconObject().getValue())
                        .setCurrency(account.getCurrencyObject().getShortName())
                        .setType(account.getAccountType().getValue())
                        .setCreationDate(account.getCreationDate())
                        .setExpirationDate(account.getExpirationDate()))
                .collect(Collectors.toList());
    }

    public Long addAccount(AccountRequestDto request) {
        Icon icon = iconRepo.findFirstByValue(request.getIcon());
        AccountType at = atRepo.findFirstByValue(request.getType());
        if (icon != null && at != null) {
            Account account = new Account()
                    .setName(request.getName())
                    .setValue(request.getLimit())
                    .setLimit(0L)
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
}
