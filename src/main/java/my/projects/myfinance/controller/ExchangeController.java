package my.projects.myfinance.controller;

import my.projects.myfinance.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/exchange")
@CrossOrigin(origins = "*")
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    @GetMapping
    @ResponseBody
    public Double getExchangeRate(@RequestParam String source,
                                  @RequestParam String destination,
                                  @RequestParam String date) throws ParseException {
        return exchangeService.getExchangeRate(source, destination, date);
    }
}
