package my.projects.myfinance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRequestDto {

    Long id;
    Date date;
    Integer from;
    Integer fromValue;
    String fromCurrency;
    Integer to;
    Integer toValue;
    String toCurrency;
    String description;

    public TransactionRequestDto() {
    }

    public TransactionRequestDto(Long id, Date date, Integer from, Integer fromValue, String fromCurrency, Integer to, Integer toValue, String toCurrency, String description) {
        this.id = id;
        this.date = date;
        this.from = from;
        this.fromValue = fromValue;
        this.fromCurrency = fromCurrency;
        this.to = to;
        this.toValue = toValue;
        this.toCurrency = toCurrency;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getFromValue() {
        return fromValue;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public Integer getTo() {
        return to;
    }

    public Integer getToValue() {
        return toValue;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public void setFromValue(Integer fromValue) {
        this.fromValue = fromValue;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public void setToValue(Integer toValue) {
        this.toValue = toValue;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
