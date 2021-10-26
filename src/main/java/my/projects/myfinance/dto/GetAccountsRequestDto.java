package my.projects.myfinance.dto;

public class GetAccountsRequestDto {

    int userId;

    public GetAccountsRequestDto() {
    }

    public GetAccountsRequestDto(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
