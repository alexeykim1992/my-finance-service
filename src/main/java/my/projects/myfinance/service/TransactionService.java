package my.projects.myfinance.service;

import my.projects.myfinance.model.Transaction;
import my.projects.myfinance.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    public List<Transaction> getTransactions(int userId) {
        return transactionRepo.getTransactionByUserId(userId);
    }
}
