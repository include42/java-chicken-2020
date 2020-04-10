package exception;

public class IllegalMenuException extends RuntimeException {
    public IllegalMenuException() {
        super("잘못된 메뉴를 입력하셨습니다.");
    }
}
