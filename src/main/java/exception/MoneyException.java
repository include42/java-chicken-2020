package exception;

public class MoneyException extends RuntimeException {
    public MoneyException() {
        super("잘못된 금액을 입력하셨습니다.");
    }
}
