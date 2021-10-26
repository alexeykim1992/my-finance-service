package my.projects.myfinance;

import my.projects.myfinance.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFinanceApplication implements CommandLineRunner {

    @Autowired
    ImportService service;

    public static void main(String[] args) {
        SpringApplication.run(MyFinanceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        service.parseTransaction("src/main/resources/export/transactions.csv");
//        System.out.println("Загрузка завершена");
    }
}
