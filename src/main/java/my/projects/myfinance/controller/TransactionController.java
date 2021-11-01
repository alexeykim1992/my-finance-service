package my.projects.myfinance.controller;

import my.projects.myfinance.dto.TransactionRequestDto;
import my.projects.myfinance.model.Transaction;
import my.projects.myfinance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "http://localhost:8080")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    @ResponseBody
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
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
}
