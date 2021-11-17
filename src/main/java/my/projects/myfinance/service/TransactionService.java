package my.projects.myfinance.service;

import my.projects.myfinance.dto.TransactionRequestDto;
import my.projects.myfinance.model.Transaction;
import my.projects.myfinance.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    UserService userService;

    public Transaction getTransaction(Long transactionId) {
        return transactionRepo.findFirstByIdAndUserId(
                transactionId, userService.getCurrentUserId());
    }

    public List<Transaction> getTransactions() {
        return transactionRepo.getTransactionByUserId(userService.getCurrentUserId());
    }

    public List<Transaction> getTransactions(Integer accountId){
        return transactionRepo.getAllTransactions(userService.getCurrentUserId(), accountId);
    }

    public List<Transaction> getDebitTransactions(Integer accountId) {
        return transactionRepo.getDebitTransactions(userService.getCurrentUserId(), accountId);
    }

    public List<Transaction> getCreditTransactions(Integer accountId) {
        return transactionRepo.getCreditTransactions(userService.getCurrentUserId(), accountId);
    }

    public Long addTransaction(TransactionRequestDto request) {
        Transaction transaction = new Transaction()
                .setDate(request.getDate())
                .setUserId(userService.getCurrentUserId())
                .setSourceId(request.getFrom())
                .setSourceValue(request.getValue())
                .setSourceCurrency(1)
                .setDestinationId(request.getTo())
                .setDestinationValue(request.getValue())
                .setDestinationCurrency(1)
                .setDescription(request.getDescription())
                .setCreationDate(new Timestamp(System.currentTimeMillis()));
        return transactionRepo.save(transaction).getId();
    }

    public Long editTransaction(TransactionRequestDto request) {
        Transaction transaction = this.getTransaction(request.getId());
        if (transaction != null) {
            transaction.setDate(request.getDate())
                    .setSourceId(request.getFrom())
                    .setDestinationId(request.getTo())
                    .setSourceValue(request.getValue())
                    .setDestinationValue(request.getValue())
                    .setDescription(request.getDescription());
            return transactionRepo.save(transaction).getId();
        }
        return -1L;
    }

    public Long deleteTransaction(TransactionRequestDto request) {
        Transaction transaction = this.getTransaction(request.getId());
        if (transaction != null) {
            transactionRepo.delete(transaction);
            return transaction.getId();
        }
        return -1L;
    }
}
