package my.projects.myfinance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "TRANSACTIONS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRANSACTION")
    @SequenceGenerator(name = "SEQ_TRANSACTION", sequenceName = "SEQ_TRANSACTION", allocationSize = 1)
    @Column(name = "ID")
    Long id;
    @Column(name = "DATE")
    Date date;
    @Column(name = "SOURCE_ID")
    @JsonProperty("from")
    int sourceId;
    @Column(name = "SOURCE_VALUE")
    @JsonProperty("value")
    int sourceValue;
    @Column(name = "SOURCE_CURRENCY")
    int sourceCurrency;
    @Column(name = "DESTINATION_ID")
    @JsonProperty("to")
    int destinationId;
    @Column(name = "DESTINATION_VALUE")
    int destinationValue;
    @Column(name = "DESTINATION_CURRENCY")
    int destinationCurrency;
    @Column(name = "TAGS")
    String tags;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "CREATION_DATE")
    Timestamp creationDate;
    @Column(name = "UPDATE_DATE")
    Timestamp updateDate;
    @Column(name = "USER_ID")
    int userId;

    public Transaction() {
    }

    public Transaction(Long id, Date date, int sourceId, int sourceValue, int sourceCurrency, int destinationId, int destinationValue, int destinationCurrency, String tags, String description, Timestamp creationDate, Timestamp updateDate, int userId) {
        this.id = id;
        this.date = date;
        this.sourceId = sourceId;
        this.sourceValue = sourceValue;
        this.sourceCurrency = sourceCurrency;
        this.destinationId = destinationId;
        this.destinationValue = destinationValue;
        this.destinationCurrency = destinationCurrency;
        this.tags = tags;
        this.description = description;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getSourceId() {
        return sourceId;
    }

    public int getSourceValue() {
        return sourceValue;
    }

    public int getSourceCurrency() {
        return sourceCurrency;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public int getDestinationValue() {
        return destinationValue;
    }

    public int getDestinationCurrency() {
        return destinationCurrency;
    }

    public String getTags() {
        return tags;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public int getUserId() {
        return userId;
    }

    public Transaction setId(Long id) {
        this.id = id;
        return this;
    }

    public Transaction setDate(Date date) {
        this.date = date;
        return this;
    }

    public Transaction setSourceId(int sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    public Transaction setSourceValue(int sourceValue) {
        this.sourceValue = sourceValue;
        return this;
    }

    public Transaction setSourceCurrency(int sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
        return this;
    }

    public Transaction setDestinationId(int destinationId) {
        this.destinationId = destinationId;
        return this;
    }

    public Transaction setDestinationValue(int destinationValue) {
        this.destinationValue = destinationValue;
        return this;
    }

    public Transaction setDestinationCurrency(int destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
        return this;
    }

    public Transaction setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public Transaction setDescription(String description) {
        this.description = description;
        return this;
    }

    public Transaction setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Transaction setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public Transaction setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", sourceId=" + sourceId +
                ", sourceValue=" + sourceValue +
                ", sourceCurrency=" + sourceCurrency +
                ", destinationId=" + destinationId +
                ", destinationValue=" + destinationValue +
                ", destinationCurrency=" + destinationCurrency +
                ", tags='" + tags + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", userId=" + userId +
                '}';
    }
}
