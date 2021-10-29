package my.projects.myfinance.controller;

import my.projects.myfinance.dto.AccountDto;
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

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    @ResponseBody
    public List<AccountDto> getAccounts(@RequestParam int userId) {
        return accountService.getAccounts(userId);
    }
}
