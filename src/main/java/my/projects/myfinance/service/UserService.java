package my.projects.myfinance.service;

import my.projects.myfinance.dto.UserDto;
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

    public UserDto getCurrentUserDto() {
        User user = userRepo.findFirstById(currentUser);
        if (user == null) return new UserDto();
        return new UserDto()
                .setId(user.getId())
                .setName(user.getName())
                .setLogin(user.getLogin())
                .setCreationDate(user.getCreationDate())
                .setCurrency(user.getCurrencyObject().getShortName());
    }

    public Integer getCurrentUserId() {
        return currentUser;
    }
}
