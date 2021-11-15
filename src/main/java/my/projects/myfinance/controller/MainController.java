package my.projects.myfinance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class MainController {

    @GetMapping("/")
    public String showInfo() {
        return "redirect:/swagger-ui/";
    }
}
