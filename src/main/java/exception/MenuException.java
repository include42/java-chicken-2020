package exception;

public class MenuException extends RuntimeException {
    public MenuException() {
        super("잘못된 메뉴를 입력하셨습니다.");
    }
}
