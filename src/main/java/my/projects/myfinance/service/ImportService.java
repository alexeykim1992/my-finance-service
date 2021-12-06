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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class ImportService {

    @Autowired
    TransactionImportRepo transactionImportRepo;
    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    AccountService accountService;

    public void parseTransaction(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            List<String> params = Arrays.asList(str.split("\",\""));
            if (params.size() >= 10) {
                TransactionImport transaction = new TransactionImport()
                        .setDate(new Date(System.currentTimeMillis()))
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
        transactionImportRepo.findAll().stream().map(record -> {
            Account source = accountService.getAccount(record.getSource());
            Account destination = accountService.getAccount(record.getDestination());
            if (source == null || destination == null
                    || !record.getSourceValue().matches("[0-9]+")
                    || !record.getDestinationValue().matches("[0-9]+")) {
                return null;
            }
            return new Transaction()
                    .setDate(record.getDate())
                    .setUserId(1)
                    .setSourceId(source.getId().intValue())
                    .setSourceCurrency(source.getCurrency())
                    .setSourceValue(Integer.parseInt(record.getSourceValue()))
                    .setDestinationId(destination.getId().intValue())
                    .setDestinationCurrency(destination.getCurrency())
                    .setDestinationValue(Integer.parseInt(record.getDestinationValue()))
                    .setTags(record.getTags())
                    .setDescription(record.getDescription())
                    .setCreationDate(new Timestamp(System.currentTimeMillis()));
        }).forEach(transaction -> {
            if (transaction != null) transactionRepo.save(transaction);
        });
    }
}
