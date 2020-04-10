package view;

import domain.Operation;
import domain.table.Payment;
import exception.IllegalUserInputException;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextLine();
    }

    public static int inputMenuNumber(){
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputSizeNumber(){
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static Payment inputPaymentNumber(){
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        try {
            return Payment.findPaymentByKey(scanner.nextLine());
        } catch(IllegalUserInputException e) {
            System.out.println(e.getMessage());
            return inputPaymentNumber();
        }
    }

    public static Operation inputOperation() {
        OutputView.printFormat();
        try {
            return Operation.createOperationByKey(scanner.nextLine());
        } catch (IllegalUserInputException e) {
            System.out.println(e.getMessage());
            return inputOperation();
        }
    }
}
