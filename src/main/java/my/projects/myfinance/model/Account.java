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
    Long value;
    @Column(name = "ACCOUNT_LIMIT")
    Long limit;
    @Column(name = "ICON")
    int icon;
    @Column(name = "CURRENCY")
    int currency;
    @Column(name = "ACCOUNT_TYPE")
    short type;
    @Column(name = "CREATION_DATE")
    Timestamp creationDate;
    @Column(name = "UPDATE_DATE")
    Timestamp updateDate;
    @Column(name = "EXPIRATION_DATE")
    Timestamp expirationDate;
    @Column(name = "USER_ID")
    int userId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ICON", referencedColumnName = "ID", insertable = false, updatable = false)
    Icon iconObject;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CURRENCY", referencedColumnName = "ID", insertable = false, updatable = false)
    Currency currencyObject;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ACCOUNT_TYPE", referencedColumnName = "ID", insertable = false, updatable = false)
    AccountType accountType;

    public Account() {
    }

    public Account(int id, String name, Long value, Long limit, int icon, int currency, short type, Timestamp creationDate, Timestamp updateDate, Timestamp expirationDate, int userId, Icon iconObject, Currency currencyObject, AccountType accountType) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.limit = limit;
        this.icon = icon;
        this.currency = currency;
        this.type = type;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.expirationDate = expirationDate;
        this.userId = userId;
        this.iconObject = iconObject;
        this.currencyObject = currencyObject;
        this.accountType = accountType;
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

    public int getIcon() {
        return icon;
    }

    public int getCurrency() {
        return currency;
    }

    public short getType() {
        return type;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public int getUserId() {
        return userId;
    }

    public Icon getIconObject() {
        return iconObject;
    }

    public Currency getCurrencyObject() {
        return currencyObject;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Account setId(int id) {
        this.id = id;
        return this;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public Account setValue(Long value) {
        this.value = value;
        return this;
    }

    public Account setLimit(Long limit) {
        this.limit = limit;
        return this;
    }

    public Account setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public Account setCurrency(int currency) {
        this.currency = currency;
        return this;
    }

    public Account setType(short type) {
        this.type = type;
        return this;
    }

    public Account setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Account setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
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
