package exception;

public class IllegalUserInputException extends RuntimeException {
    public IllegalUserInputException() {
        super("잘못된 입력입니다. 다시 입력해 주세요.");
    }
}
