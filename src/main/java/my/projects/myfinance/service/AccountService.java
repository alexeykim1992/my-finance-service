package my.projects.myfinance.service;

import my.projects.myfinance.model.Account;
import my.projects.myfinance.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;

    public List<Account> getAccounts(int userId){
        return accountRepo.getAccountByUserId(userId);
    }
}
