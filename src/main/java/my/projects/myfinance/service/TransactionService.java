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

    public List<Transaction> getTransactions(int userId) {
        return transactionRepo.getTransactionByUserId(userId);
    }

    public Long addTransaction(TransactionRequestDto request) {
        Transaction transaction = new Transaction()
                .setDate(request.getDate())
                .setUserId(2)
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
        Transaction transaction = transactionRepo.findFirstById(request.getId());
        if(transaction!= null){
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
}
