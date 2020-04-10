package domain.table;

import domain.customer.Customer;
import domain.menu.Menu;
import domain.money.Money;
import exception.IllegalMenuException;
import exception.IllegalTableException;

public class Table {
    private final int number;
    private final Customer customer;

    // TODO: 2020/04/10 생성자의 패키지 액세스 포인트 추후 문서화
    /*package-accessed Constructor*/
    Table(final int number) {
        validateTableNumber(number);
        this.number = number;
        customer = new Customer();
    }

    private void validateTableNumber(int number) {
        if(number <= 0) {
            throw new IllegalTableException(number);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void order(Menu menu, int menuNumber) {
        validateMenuNumber(menuNumber);
        customer.add(menu,menuNumber);
    }

    private void validateMenuNumber(int menuNumber) {
        if(menuNumber <= 0 || menuNumber >= 100) {
            throw new IllegalMenuException();
        }
    }

    public Money calculate(Payment payment) {
        Money money = customer.calculateMoney();
        double discount = payment.getDiscount();
        return money.multiply(discount);
    }
}
