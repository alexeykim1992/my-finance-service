package my.projects.myfinance.service;

import my.projects.myfinance.model.User;
import my.projects.myfinance.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User getCurrentUser() {
        return userRepo.findFirstById(1);
    }

    public Integer getCurrentUserId(){
        return 1;
    }
}
