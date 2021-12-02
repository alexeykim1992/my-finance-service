package my.projects.myfinance.controller;

import my.projects.myfinance.dto.UserDto;
import my.projects.myfinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @ResponseBody
    public UserDto getCurrentUser() {
        return userService.getCurrentUserDto();
    }
}
