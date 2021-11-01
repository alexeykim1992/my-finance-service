package my.projects.myfinance.controller;

import my.projects.myfinance.model.Icon;
import my.projects.myfinance.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/icon")
@CrossOrigin(origins = "http://localhost:8080")
public class IconController {

    @Autowired
    IconService iconService;

    @GetMapping
    @ResponseBody
    public List<Icon> getIcons() {
        return iconService.getIcons();
    }
}
