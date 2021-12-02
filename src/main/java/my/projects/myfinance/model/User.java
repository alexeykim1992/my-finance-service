package my.projects.myfinance.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID")
    Integer id;
    @Column(name = "NAME")
    String name;
    @Column(name = "LOGIN")
    String login;
    @Column(name = "CREATION_DATE")
    Timestamp creationDate;
    @Column(name = "CURRENCY")
    Integer currency;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CURRENCY", referencedColumnName = "ID", insertable = false, updatable = false)
    Currency currencyObject;

    public User() {
    }

    public User(Integer id, String name, String login, Timestamp creationDate, Integer currency) {
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

    public Integer getCurrency() {
        return currency;
    }

    public Currency getCurrencyObject() {
        return currencyObject;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public User setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public User setCurrency(Integer currency) {
        this.currency = currency;
        return this;
    }
}
