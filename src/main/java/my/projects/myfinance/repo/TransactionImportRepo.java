package my.projects.myfinance.repo;

import my.projects.myfinance.model.TransactionImport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionImportRepo extends JpaRepository<TransactionImport, Long> {


}
