package my.projects.myfinance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class UserDto {

    @JsonProperty(index = 0)
    Integer id;
    @JsonProperty(index = 1)
    String name;
    @JsonProperty(index = 2)
    String login;
    @JsonProperty(index = 3)
    Timestamp creationDate;
    @JsonProperty(index = 4)
    String currency;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String login, Timestamp creationDate, String currency) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.creationDate = creationDate;
        this.currency = currency;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public String getCurrency() {
        return currency;
    }

    public UserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public UserDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserDto setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public UserDto setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
