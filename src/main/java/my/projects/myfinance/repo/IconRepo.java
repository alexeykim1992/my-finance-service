package my.projects.myfinance.repo;

import my.projects.myfinance.model.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepo extends JpaRepository<Icon, Integer> {

    Icon findFirstByValue(String value);
}
