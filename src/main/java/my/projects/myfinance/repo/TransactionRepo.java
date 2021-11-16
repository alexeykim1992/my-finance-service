package my.projects.myfinance.repo;

import my.projects.myfinance.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    List<Transaction> getTransactionByUserId(int userId);

    Transaction findFirstByIdAAndUserId(Long id, Integer userId);
}
