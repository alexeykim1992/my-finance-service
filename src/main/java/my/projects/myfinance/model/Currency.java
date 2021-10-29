package my.projects.myfinance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE_CURRENCY")
public class Currency {

    @Id
    @Column(name = "ID")
    int id;
    @Column(name = "NAME")
    String name;
    @Column(name = "SHORT")
    String shortName;

    public Currency() {
    }

    public Currency(int id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
