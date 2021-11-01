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

    public List<AccountDto> getAccounts(int userId) {
        return accountRepo.getAccountByUserId(userId).stream().map(account -> new AccountDto()
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

    public Integer addAccount(AccountRequestDto request) {
        Icon icon = iconRepo.findFirstByValue(request.getIcon());
        AccountType at = atRepo.findFirstByValue(request.getType());
        if (icon != null && at != null) {
            Account account = new Account()
                    .setName(request.getName())
                    .setValue(0L)
                    .setLimit(0L)
                    .setIcon(icon.getId())
                    .setCurrency(1)
                    .setType(at.getId())
                    .setCreationDate(new Timestamp(System.currentTimeMillis()))
                    .setUserId(2);
            accountRepo.save(account);
            return account.getId();
        }
        return -1;
    }

    public Integer editAccount(AccountRequestDto request) {
        Account account = accountRepo.findFirstById(request.getId());
        Icon icon = iconRepo.findFirstByValue(request.getIcon());
        AccountType at = atRepo.findFirstByValue(request.getType());
        if (account != null && icon != null && at != null) {
            account.setName(request.getName())
                    .setIcon(icon.getId())
                    .setType(at.getId())
                    .setUpdateDate(new Timestamp(System.currentTimeMillis()));
            accountRepo.save(account);
        }
        return -1;
    }
}
