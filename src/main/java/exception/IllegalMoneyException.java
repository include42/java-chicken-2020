package exception;

public class IllegalMoneyException extends RuntimeException {
    public IllegalMoneyException() {
        super("잘못된 금액을 입력하셨습니다.");
    }
}
