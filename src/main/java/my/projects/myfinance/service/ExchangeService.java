package my.projects.myfinance.service;

import my.projects.myfinance.model.Currency;
import my.projects.myfinance.model.ExchangeRate;
import my.projects.myfinance.repo.CurrencyRepo;
import my.projects.myfinance.repo.ExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ExchangeService {

    @Autowired
    ExchangeRepo exchangeRepo;
    @Autowired
    CurrencyRepo currencyRepo;

    public Double getRate(String source, String destination, String date) throws ParseException {
        if (source.equals(destination)) return 1.;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Currency sourceCurrency = currencyRepo.findFirstByShortName(source);
        Currency destinationCurrency = currencyRepo.findFirstByShortName(destination);
        if (sourceCurrency == null || destinationCurrency == null) return 0.;
        List<ExchangeRate> sourceRate = exchangeRepo.findExchangeRate(
                sourceCurrency.getId(), sdf.parse(date), PageRequest.of(0, 1));
        List<ExchangeRate> destinationRate = exchangeRepo.findExchangeRate(
                destinationCurrency.getId(), sdf.parse(date), PageRequest.of(0, 1));
        return destinationRate.get(0).getRate() / sourceRate.get(0).getRate();
    }
}
