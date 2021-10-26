package my.projects.myfinance.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TRANSACTION_IMPORT")
public class TransactionImport {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_TRANSACTION")
    @SequenceGenerator(name="SEQ_TRANSACTION", sequenceName = "SEQ_TRANSACTION", allocationSize=1)
    Long id;
    Date date;
    String type;
    String source;
    String destination;
    String tags;
    @Column(name = "SOURCE_VALUE")
    String sourceValue;
    @Column(name = "SOURCE_CURRENCY")
    String sourceCurrency;
    @Column(name = "DESTINATION_VALUE")
    String destinationValue;
    @Column(name = "DESTINATION_CURRENCY")
    String destinationCurrency;
    String recurrent;
    String description;

    public TransactionImport() {
    }

    public TransactionImport(Long id, Date date, String type, String source, String destination, String tags, String sourceValue, String sourceCurrency, String destinationValue, String destinationCurrency, String recurrent, String description) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.source = source;
        this.destination = destination;
        this.tags = tags;
        this.sourceValue = sourceValue;
        this.sourceCurrency = sourceCurrency;
        this.destinationValue = destinationValue;
        this.destinationCurrency = destinationCurrency;
        this.recurrent = recurrent;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getTags() {
        return tags;
    }

    public String getSourceValue() {
        return sourceValue;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public String getDestinationValue() {
        return destinationValue;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public String getRecurrent() {
        return recurrent;
    }

    public String getDescription() {
        return description;
    }

    public TransactionImport setId(Long id) {
        this.id = id;
        return this;
    }

    public TransactionImport setDate(Date date) {
        this.date = date;
        return this;
    }

    public TransactionImport setType(String type) {
        this.type = type;
        return this;
    }

    public TransactionImport setSource(String source) {
        this.source = source;
        return this;
    }

    public TransactionImport setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public TransactionImport setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public TransactionImport setSourceValue(String sourceValue) {
        this.sourceValue = sourceValue;
        return this;
    }

    public TransactionImport setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
        return this;
    }

    public TransactionImport setDestinationValue(String destinationValue) {
        this.destinationValue = destinationValue;
        return this;
    }

    public TransactionImport setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
        return this;
    }

    public TransactionImport setRecurrent(String recurrent) {
        this.recurrent = recurrent;
        return this;
    }

    public TransactionImport setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "TransactionExport{" +
                "date=" + date +
                ", type='" + type + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", tags='" + tags + '\'' +
                ", sourceValue='" + sourceValue + '\'' +
                ", sourceCurrency='" + sourceCurrency + '\'' +
                ", destinationValue='" + destinationValue + '\'' +
                ", destinationCurrency='" + destinationCurrency + '\'' +
                ", recurrent='" + recurrent + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
