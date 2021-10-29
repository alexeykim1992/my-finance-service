package my.projects.myfinance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE_ICON")
public class Icon {

    @Id
    @Column(name = "ID")
    int id;
    @Column(name = "NAME")
    String name;
    @Column(name = "VALUE")
    String value;

    public Icon() {
    }

    public Icon(int id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    public Icon setId(int id) {
        this.id = id;
        return this;
    }

    public Icon setName(String name) {
        this.name = name;
        return this;
    }

    public Icon setValue(String value) {
        this.value = value;
        return this;
    }
}
