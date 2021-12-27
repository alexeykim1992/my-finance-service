package my.projects.myfinance.repo;

import my.projects.myfinance.model.ExchangeRate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExchangeRepo extends JpaRepository<ExchangeRate, Long> {

    @Query("SELECT er FROM ExchangeRate er " +
            "WHERE er.destination = ?1 and er.date < ?2 " +
            "ORDER BY er.date DESC")
    List<ExchangeRate> findExchangeRate(Integer destination, Date date, Pageable pageable);
}
