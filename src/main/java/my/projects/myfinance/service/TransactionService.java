package my.projects.myfinance.service;

import my.projects.myfinance.dto.TransactionDto;
import my.projects.myfinance.dto.TransactionRequestDto;
import my.projects.myfinance.model.Transaction;
import my.projects.myfinance.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<TransactionDto> getTransactions() {
        return transactionRepo.getTransactionByUserId(userService.getCurrentUserId()).stream()
                .map(transaction -> new TransactionDto()
                        .setId(transaction.getId())
                        .setDate(transaction.getDate())
                        .setSourceId(transaction.getSourceId())
                        .setSourceValue(transaction.getSourceValue())
                        .setSourceCurrency(transaction.getSourceCurrencyObject() == null ? "!!!"
                                : transaction.getSourceCurrencyObject().getShortName())
                        .setDestinationId(transaction.getDestinationId())
                        .setDestinationValue(transaction.getDestinationValue())
                        .setDestinationCurrency(transaction.getDestinationCurrencyObject() == null ? "!!!"
                                : transaction.getDestinationCurrencyObject().getShortName())
                        .setTags(transaction.getTags())
                        .setDescription(transaction.getDescription())
                        .setCreationDate(transaction.getCreationDate())
                        .setUpdateDate(transaction.getUpdateDate()))
                .collect(Collectors.toList());
    }

    public List<Transaction> getTransactions(Integer accountId) {
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
                .setSourceValue(request.getFromValue())
                .setSourceCurrency(1)
                .setDestinationId(request.getTo())
                .setDestinationValue(request.getToValue())
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
                    .setSourceValue(request.getFromValue())
                    .setDestinationValue(request.getToValue())
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
