package exception;

public class IllegalTableException extends RuntimeException {

    public static final String ERROR_TABLE_MESSAGE = "잘못된 테이블 번호를 입력하셨습니다.";

    public IllegalTableException() {
        super(ERROR_TABLE_MESSAGE);
    }

    public IllegalTableException(int value) {
        super(String.format("%s 입력 : %d", ERROR_TABLE_MESSAGE, value));
    }
}
