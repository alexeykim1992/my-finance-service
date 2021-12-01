package my.projects.myfinance.repo;

import my.projects.myfinance.model.AccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBalanceRepo extends JpaRepository<AccountBalance, Long> {

    AccountBalance findFirstByAccountIdAndMonth(Long accountId, String month);
}
