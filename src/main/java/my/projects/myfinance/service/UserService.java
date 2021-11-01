package my.projects.myfinance.service;

import my.projects.myfinance.model.User;
import my.projects.myfinance.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    private final static Integer currentUser = 2;

    public User getCurrentUser() {
        return userRepo.findFirstById(currentUser);
    }

    public Integer getCurrentUserId() {
        return currentUser;
    }
}
