package my.projects.myfinance.controller;

import my.projects.myfinance.dto.AccountDto;
import my.projects.myfinance.dto.AccountRequestDto;
import my.projects.myfinance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    @ResponseBody
    public List<AccountDto> getAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping
    @ResponseBody
    public Long addAccount(@RequestBody AccountRequestDto request) {
        return accountService.addAccount(request);
    }

    @PutMapping
    @ResponseBody
    public Long editAccount(@RequestBody AccountRequestDto request) {
        return accountService.editAccount(request);
    }

    @DeleteMapping
    @ResponseBody
    public Long deleteAccount(@RequestBody AccountRequestDto request) {
        return accountService.softDeleteAccount(request);
    }

    @GetMapping("/calculate")
    @ResponseBody
    public Integer calculate() {
        return accountService.calculateAllBalances();
    }
}
