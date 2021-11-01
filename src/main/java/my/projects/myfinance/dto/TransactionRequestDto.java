package my.projects.myfinance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRequestDto {

    Long id;
    Date date;
    Integer from;
    Integer to;
    Integer value;
    String description;

    public TransactionRequestDto() {
    }

    public TransactionRequestDto(Long id, Date date, Integer from, Integer to, Integer value, String description) {
        this.id = id;
        this.date = date;
        this.from = from;
        this.to = to;
        this.value = value;
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

    public Integer getTo() {
        return to;
    }

    public Integer getValue() {
        return value;
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

    public void setTo(Integer to) {
        this.to = to;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
