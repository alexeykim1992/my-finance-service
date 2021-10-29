package my.projects.myfinance.dto;

import javax.persistence.Column;
import java.sql.Timestamp;

public class AccountDto {

    int id;
    String name;
    Long value;
    Long limit;
    String icon;
    String currency;
    String type;
    Timestamp creationDate;
    Timestamp expirationDate;

    public AccountDto() {
    }

    public AccountDto(int id, String name, Long value, Long limit, String icon, String currency, String type, Timestamp creationDate, Timestamp expirationDate) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.limit = limit;
        this.icon = icon;
        this.currency = currency;
        this.type = type;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getValue() {
        return value;
    }

    public Long getLimit() {
        return limit;
    }

    public String getIcon() {
        return icon;
    }

    public String getCurrency() {
        return currency;
    }

    public String getType() {
        return type;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public AccountDto setId(int id) {
        this.id = id;
        return this;
    }

    public AccountDto setName(String name) {
        this.name = name;
        return this;
    }

    public AccountDto setValue(Long value) {
        this.value = value;
        return this;
    }

    public AccountDto setLimit(Long limit) {
        this.limit = limit;
        return this;
    }

    public AccountDto setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public AccountDto setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public AccountDto setType(String type) {
        this.type = type;
        return this;
    }

    public AccountDto setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public AccountDto setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }
}
