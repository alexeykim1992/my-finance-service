package my.projects.myfinance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountRequestDto {

    Long id;
    String name;
    String type;
    String icon;

    public AccountRequestDto() {
    }

    public AccountRequestDto(Long id, String name, String type, String icon) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getIcon() {
        return icon;
    }

    public AccountRequestDto setId(Long id) {
        this.id = id;
        return this;
    }

    public AccountRequestDto setName(String name) {
        this.name = name;
        return this;
    }

    public AccountRequestDto setType(String type) {
        this.type = type;
        return this;
    }

    public AccountRequestDto setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public String toString() {
        return "AccountAddRequestDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
