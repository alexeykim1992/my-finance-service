package my.projects.myfinance.controller;

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

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    @ResponseBody
    public List<Transaction> getTransactions(@RequestParam int userId) {
        return transactionService.getTransactions(userId);
    }
}
