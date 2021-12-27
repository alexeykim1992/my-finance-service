package my.projects.myfinance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "EXCHANGE")
public class ExchangeRate {

    @Id
    Long id;
    Integer destination;
    Date date;
    Double rate;

    public ExchangeRate() {
    }

    public ExchangeRate(Long id, Integer destination, Date date, Double rate) {
        this.id = id;
        this.destination = destination;
        this.date = date;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
