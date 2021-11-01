package my.projects.myfinance.repo;

import my.projects.myfinance.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepo extends JpaRepository<AccountType, Integer> {

    AccountType findFirstByValue(String value);
}
