package my.projects.myfinance.service;

import my.projects.myfinance.dto.AccountDto;
import my.projects.myfinance.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;

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
}
