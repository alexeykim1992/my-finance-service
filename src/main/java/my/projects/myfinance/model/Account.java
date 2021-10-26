package my.projects.myfinance.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCOUNT")
    @SequenceGenerator(name = "SEQ_ACCOUNT", sequenceName = "SEQ_ACCOUNT", allocationSize = 1)
    @Column(name = "ID")
    int id;
    @Column(name = "NAME")
    String name;
    @Column(name = "VALUE")
    String value;
    @Column(name = "LIMIT")
    String limit;
    @Column(name = "ICON")
    String icon;
    @Column(name = "CURRENCY")
    int currency;
    @Column(name = "TYPE")
    int type;
    @Column(name = "CREATION_DATE")
    Timestamp creationDate;
    @Column(name = "EXPIRATION_DATE")
    Timestamp expirationDate;
    @Column(name = "USER_ID")
    int userId;

    public Account() {
    }

    public Account(int id, String name, String value, String limit, String icon, int currency, int type, Timestamp creationDate, Timestamp expirationDate, int userId) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.limit = limit;
        this.icon = icon;
        this.currency = currency;
        this.type = type;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getLimit() {
        return limit;
    }

    public String getIcon() {
        return icon;
    }

    public int getCurrency() {
        return currency;
    }

    public int getType() {
        return type;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public int getUserId() {
        return userId;
    }

    public Account setId(int id) {
        this.id = id;
        return this;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public Account setValue(String value) {
        this.value = value;
        return this;
    }

    public Account setLimit(String limit) {
        this.limit = limit;
        return this;
    }

    public Account setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Account setCurrency(int currency) {
        this.currency = currency;
        return this;
    }

    public Account setType(int type) {
        this.type = type;
        return this;
    }

    public Account setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Account setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public Account setUserId(int userId) {
        this.userId = userId;
        return this;
    }
}
