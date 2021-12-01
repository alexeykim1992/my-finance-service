package my.projects.myfinance.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ACCOUNT_BALANCE")
public class AccountBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCOUNT_BALANCE")
    @SequenceGenerator(name = "SEQ_ACCOUNT_BALANCE", sequenceName = "SEQ_ACCOUNT_BALANCE", allocationSize = 1)
    @Column(name = "ID")
    Long id;
    @Column(name = "ACCOUNT_ID")
    Long accountId;
    @Column(name = "MONTH")
    String month;
    @Column(name = "VALUE_BEFORE")
    Long valueBefore;
    @Column(name = "VALUE_CHANGE")
    Long valueChange;
    @Column(name = "VALUE_AFTER")
    Long valueAfter;
    @Column(name = "UPDATE_DATE")
    Timestamp updateDate;

    public AccountBalance() {
    }

    public AccountBalance(Long id, Long accountId, String month, Long valueBefore, Long valueChange, Long valueAfter, Timestamp updateDate) {
        this.id = id;
        this.accountId = accountId;
        this.month = month;
        this.valueBefore = valueBefore;
        this.valueChange = valueChange;
        this.valueAfter = valueAfter;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getMonth() {
        return month;
    }

    public Long getValueBefore() {
        return valueBefore;
    }

    public Long getValueChange() {
        return valueChange;
    }

    public Long getValueAfter() {
        return valueAfter;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public AccountBalance setId(Long id) {
        this.id = id;
        return this;
    }

    public AccountBalance setAccountId(Long accountId) {
        this.accountId = accountId;
        return this;
    }

    public AccountBalance setMonth(String month) {
        this.month = month;
        return this;
    }

    public AccountBalance setValueBefore(Long valueBefore) {
        this.valueBefore = valueBefore;
        return this;
    }

    public AccountBalance setValueChange(Long valueChange) {
        this.valueChange = valueChange;
        return this;
    }

    public AccountBalance setValueAfter(Long valueAfter) {
        this.valueAfter = valueAfter;
        return this;
    }

    public AccountBalance setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
        return this;
    }
}
