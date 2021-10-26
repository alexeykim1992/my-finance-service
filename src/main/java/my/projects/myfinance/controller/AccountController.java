package my.projects.myfinance.controller;

import my.projects.myfinance.dto.GetAccountsRequestDto;
import my.projects.myfinance.model.Account;
import my.projects.myfinance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    @ResponseBody
    public List<Account> getAccounts(@RequestBody GetAccountsRequestDto request) {
        return accountService.getAccounts(request.getUserId());
    }
}
