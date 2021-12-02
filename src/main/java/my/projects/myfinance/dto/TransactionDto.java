package my.projects.myfinance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.sql.Timestamp;

public class TransactionDto {

    @JsonProperty(index = 0)
    Long id;
    @JsonProperty(index = 1)
    Date date;
    @JsonProperty(value = "from", index = 2)
    int sourceId;
    @JsonProperty(value = "fromValue", index = 3)
    int sourceValue;
    @JsonProperty(value = "fromCurrency", index = 4)
    String sourceCurrency;
    @JsonProperty(value = "to", index = 5)
    int destinationId;
    @JsonProperty(value = "toValue", index = 6)
    int destinationValue;
    @JsonProperty(value = "toCurrency", index = 7)
    String destinationCurrency;
    @JsonProperty(index = 8)
    String tags;
    @JsonProperty(index = 9)
    String description;
    @JsonProperty(index = 10)
    Timestamp creationDate;
    @JsonProperty(index = 11)
    Timestamp updateDate;

    public TransactionDto() {
    }

    public TransactionDto(Long id, Date date, int sourceId, int sourceValue, String sourceCurrency, int destinationId, int destinationValue, String destinationCurrency, String tags, String description, Timestamp creationDate, Timestamp updateDate) {
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

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public int getDestinationValue() {
        return destinationValue;
    }

    public String getDestinationCurrency() {
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

    public TransactionDto setId(Long id) {
        this.id = id;
        return this;
    }

    public TransactionDto setDate(Date date) {
        this.date = date;
        return this;
    }

    public TransactionDto setSourceId(int sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    public TransactionDto setSourceValue(int sourceValue) {
        this.sourceValue = sourceValue;
        return this;
    }

    public TransactionDto setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
        return this;
    }

    public TransactionDto setDestinationId(int destinationId) {
        this.destinationId = destinationId;
        return this;
    }

    public TransactionDto setDestinationValue(int destinationValue) {
        this.destinationValue = destinationValue;
        return this;
    }

    public TransactionDto setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
        return this;
    }

    public TransactionDto setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public TransactionDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public TransactionDto setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public TransactionDto setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
        return this;
    }
}
