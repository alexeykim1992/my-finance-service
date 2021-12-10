package my.projects.myfinance.service;

import my.projects.myfinance.model.Account;
import my.projects.myfinance.model.Transaction;
import my.projects.myfinance.model.TransactionImport;
import my.projects.myfinance.repo.TransactionImportRepo;
import my.projects.myfinance.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Service
public class ImportService {

    @Autowired
    TransactionImportRepo transactionImportRepo;
    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    AccountService accountService;

    public void parseTransaction(String filename) throws FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(new File(filename));
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        while (scanner.hasNextLine()) {
            List<String> params = Arrays.asList(scanner.nextLine().split("\",\""));
            if (params.size() >= 10) {
                TransactionImport transaction = new TransactionImport()
                        .setDate(new Date(sdf.parse(
                                params.get(0).replace("\"", "")).getTime()))
                        .setType(params.get(1))
                        .setSource(params.get(2))
                        .setDestination(params.get(3))
                        .setTags(params.get(4))
                        .setSourceValue(params.get(5))
                        .setSourceCurrency(params.get(6))
                        .setDestinationValue(params.get(7))
                        .setDestinationCurrency(params.get(8))
                        .setRecurrent(params.get(9))
                        .setDescription(params.get(10).replace("\"", ""));
                transactionImportRepo.save(transaction);
            } else {
                System.out.println(params);
            }
        }
    }

    public void transportToMainTable() {
        transactionImportRepo.findAll().stream()
                .map(record -> {
                    Account source = accountService.getAccount(record.getSource());
                    Account destination = accountService.getAccount(record.getDestination());
                    if (source == null || destination == null) {
                        System.out.println(record.getSource() + " => " + record.getDestination());
                        return null;
                    }
                    return new Transaction()
                            .setDate(record.getDate())
                            .setUserId(1)
                            .setSourceId(source.getId().intValue())
                            .setSourceCurrency(source.getCurrency())
                            .setSourceValue(
                                    Math.round(Float.parseFloat(
                                            record.getSourceValue().replace(",", "."))))
                            .setDestinationId(destination.getId().intValue())
                            .setDestinationCurrency(destination.getCurrency())
                            .setDestinationValue(
                                    Math.round(Float.parseFloat(
                                            record.getDestinationValue().replace(",", "."))))
                            .setTags(record.getTags())
                            .setDescription(record.getDescription())
                            .setCreationDate(new Timestamp(System.currentTimeMillis()));
                })
                .filter(Objects::nonNull)
                .forEach(transaction -> transactionRepo.save(transaction));
    }
}
