package my.projects.myfinance.controller;

import my.projects.myfinance.dto.TransactionDto;
import my.projects.myfinance.dto.TransactionRequestDto;
import my.projects.myfinance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    @ResponseBody
    public List<TransactionDto> getTransactions(@RequestParam(required = false) String month) {
        return transactionService.getTransactions(month);
    }

    @PostMapping
    @ResponseBody
    public Long addTransaction(@RequestBody TransactionRequestDto request) {
        return transactionService.addTransaction(request);
    }

    @PutMapping
    @ResponseBody
    public Long editTransaction(@RequestBody TransactionRequestDto request) {
        return transactionService.editTransaction(request);
    }

    @DeleteMapping
    @ResponseBody
    public Long deleteTransaction(@RequestBody TransactionRequestDto request) {
        return transactionService.deleteTransaction(request);
    }
}
