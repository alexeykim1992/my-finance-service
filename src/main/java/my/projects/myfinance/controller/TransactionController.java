package my.projects.myfinance.controller;

import my.projects.myfinance.dto.GetTransactionsRequestDto;
import my.projects.myfinance.model.Transaction;
import my.projects.myfinance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    @ResponseBody
    public List<Transaction> getTransactions(@RequestBody GetTransactionsRequestDto request) {
        return transactionService.getTransactions(request.getUserId());
    }
}
