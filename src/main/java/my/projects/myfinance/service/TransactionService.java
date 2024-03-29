package my.projects.myfinance.service;

import my.projects.myfinance.dto.TransactionDto;
import my.projects.myfinance.dto.TransactionRequestDto;
import my.projects.myfinance.model.Account;
import my.projects.myfinance.model.Transaction;
import my.projects.myfinance.repo.AccountRepo;
import my.projects.myfinance.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    UserService userService;
    @Autowired
    AccountRepo accountRepo;

    public Transaction getTransaction(Long transactionId) {
        return transactionRepo.findFirstByIdAndUserId(
                transactionId, userService.getCurrentUserId());
    }

    public List<TransactionDto> getTransactions(String yearMonth) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

        return transactionRepo.getTransactionByUserId(userService.getCurrentUserId()).stream()
                .filter(transaction -> {
                    String transactionYearMonth = transaction.getDate() != null
                            ? sdf.format(transaction.getDate()) : "";
                    return transactionYearMonth.equals(
                            yearMonth == null ? sdf.format(new Date()) : yearMonth);
                })
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
        Account fromAccount = accountRepo.findFirstByIdAndUserId(
                request.getFrom().longValue(), userService.getCurrentUserId());
        Account toAccount = accountRepo.findFirstByIdAndUserId(
                request.getTo().longValue(), userService.getCurrentUserId());
        if (fromAccount == null || toAccount == null) return -1L;

        Transaction transaction = new Transaction()
                .setDate(request.getDate())
                .setUserId(userService.getCurrentUserId())
                .setSourceId(request.getFrom())
                .setSourceValue(request.getFromValue())
                .setSourceCurrency(fromAccount.getCurrency())
                .setDestinationId(request.getTo())
                .setDestinationValue(request.getToValue())
                .setDestinationCurrency(toAccount.getCurrency())
                .setDescription(request.getDescription())
                .setCreationDate(new Timestamp(System.currentTimeMillis()));
        return transactionRepo.save(transaction).getId();
    }

    public Long editTransaction(TransactionRequestDto request) {
        Transaction transaction = this.getTransaction(request.getId());
        Account fromAccount = accountRepo.findFirstByIdAndUserId(
                request.getFrom().longValue(), userService.getCurrentUserId());
        Account toAccount = accountRepo.findFirstByIdAndUserId(
                request.getTo().longValue(), userService.getCurrentUserId());
        if (transaction == null || fromAccount == null || toAccount == null)
            return -1L;

        transaction
                .setDate(request.getDate())
                .setSourceId(request.getFrom())
                .setSourceValue(request.getFromValue())
                .setSourceCurrency(fromAccount.getCurrency())
                .setDestinationId(request.getTo())
                .setDestinationValue(request.getToValue())
                .setDestinationCurrency(toAccount.getCurrency())
                .setDescription(request.getDescription());
        return transactionRepo.save(transaction).getId();

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
