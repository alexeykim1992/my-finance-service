package my.projects.myfinance.repo;

import my.projects.myfinance.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Integer> {

    Currency findFirstByShortName(String shortName);
}
