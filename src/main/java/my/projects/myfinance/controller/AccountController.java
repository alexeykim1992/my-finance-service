package my.projects.myfinance.controller;

import my.projects.myfinance.dto.AccountAddRequestDto;
import my.projects.myfinance.dto.AccountDto;
import my.projects.myfinance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:8080")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    @ResponseBody
    public List<AccountDto> getAccounts(@RequestParam int userId) {
        return accountService.getAccounts(userId);
    }

    @PostMapping
    @ResponseBody
    public Integer addAccount(@RequestBody AccountAddRequestDto request){
        return accountService.addAccount(request);
    }
}
