package my.projects.myfinance.repo;

import my.projects.myfinance.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

    List<Account> getAccountByUserId(int userId);

    Account findFirstById(int id);
}
