package my.projects.myfinance.dto;

public class GetTransactionsRequestDto {

    int userId;

    public GetTransactionsRequestDto() {
    }

    public GetTransactionsRequestDto(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
