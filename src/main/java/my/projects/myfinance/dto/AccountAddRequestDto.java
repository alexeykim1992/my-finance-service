package my.projects.myfinance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountAddRequestDto {

    String id;
    String name;
    String type;
    String icon;

    public AccountAddRequestDto() {
    }

    public AccountAddRequestDto(String id, String name, String type, String icon) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.icon = icon;
    }

    public String getId() {
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
