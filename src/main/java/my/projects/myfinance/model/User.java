package my.projects.myfinance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    public User() {
    }

    public User(Integer id, String name, String login, Timestamp creationDate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.creationDate = creationDate;
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
}
