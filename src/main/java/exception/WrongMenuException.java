package exception;

public class WrongMenuException extends RuntimeException {
    public WrongMenuException() {
        super("잘못된 메뉴를 입력하셨습니다.");
    }
}
