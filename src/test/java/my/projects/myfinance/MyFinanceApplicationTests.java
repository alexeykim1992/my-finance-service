package my.projects.myfinance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.projects.myfinance.controller.*;
import my.projects.myfinance.dto.AccountRequestDto;
import my.projects.myfinance.model.Account;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MyFinanceApplicationTests {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    AccountController accountController;
    @Autowired
    ExchangeController exchangeController;
    @Autowired
    IconController iconController;
    @Autowired
    MainController mainController;
    @Autowired
    TransactionController transactionController;
    @Autowired
    UserController userController;
    private final static Logger log = LoggerFactory.getLogger(MyFinanceApplicationTests.class);

    @Test
    void contextLoads() {
        assertThat(accountController).isNotNull();
//        assertThat(exchangeController).isNotNull();
//        assertThat(iconController).isNotNull();
//        assertThat(mainController).isNotNull();
//        assertThat(transactionController).isNotNull();
//        assertThat(userController).isNotNull();
    }

    @Test
    void getAccountsTest() throws Exception {
        ResultActions ra = this.mockMvc.perform(get("/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .param("month", "200009"))
                .andDo(print())
                .andExpect(status().isOk());
        Arrays.asList("id", "name", "value", "limit", "icon", "currency", "type", "creationDate", "expirationDate")
                .forEach(param -> {
                    try {
                        ra.andExpect(MockMvcResultMatchers.jsonPath("$[0]." + param).hasJsonPath());
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                });
        Arrays.asList("id", "name", "value", "limit", "icon", "currency", "type", "creationDate")
                .forEach(param -> {
                    try {
                        ra.andExpect(MockMvcResultMatchers.jsonPath("$[0]." + param).isNotEmpty());
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                });
    }

    @Test
    void addAccountTest() throws Exception {
        AccountRequestDto requestDto = new AccountRequestDto()
                .setName("TestAccount")
                .setType("zzzzz")
                .setLimit(100L)
                .setIcon("far fa-bus");
        this.mockMvc.perform(post("/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNumber());
        System.out.println();
    }
}
