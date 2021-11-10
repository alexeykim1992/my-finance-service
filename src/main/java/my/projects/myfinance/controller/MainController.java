package my.projects.myfinance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showInfo() {
        return "redirect:/swagger-ui/";
    }
}
