package my.projects.myfinance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE_ACCOUNT")
public class AccountType {

    @Id
    @Column(name = "ID")
    short id;
    @Column(name = "NAME")
    String name;
    @Column(name = "VALUE")
    String value;
    @Column(name = "DESCRIPTION")
    String description;

    public AccountType() {
    }

    public AccountType(short id, String name, String value, String description) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public AccountType setId(short id) {
        this.id = id;
        return this;
    }

    public AccountType setName(String name) {
        this.name = name;
        return this;
    }

    public AccountType setValue(String value) {
        this.value = value;
        return this;
    }

    public AccountType setDescription(String description) {
        this.description = description;
        return this;
    }
}
