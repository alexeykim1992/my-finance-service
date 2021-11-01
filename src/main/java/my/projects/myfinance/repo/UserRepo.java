package my.projects.myfinance.repo;

import my.projects.myfinance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findFirstById(Integer id);
}
