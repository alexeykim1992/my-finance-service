package my.projects.myfinance.repo;

import my.projects.myfinance.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    List<Transaction> getTransactionByUserId(Integer userId);

    @Query("select trx from Transaction trx where trx.userId = ?1 and trx.sourceId = ?2")
    List<Transaction> getCreditTransactions(Integer userId, Integer accountId);

    @Query("select trx from Transaction trx where trx.userId = ?1 and trx.destinationId = ?2")
    List<Transaction> getDebitTransactions(Integer userId, Integer accountId);

    @Query("select trx from Transaction trx where trx.userId = ?1 and (trx.sourceId = ?2 or trx.destinationId = ?2)")
    List<Transaction> getAllTransactions(Integer userID, Integer accountId);

    Transaction findFirstByIdAndUserId(Long id, Integer userId);
}
