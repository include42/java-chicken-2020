package domain.table;

import domain.customer.Customer;
import domain.menu.Menu;
import domain.money.Money;
import exception.IllegalTableException;

public class Table {
    private final int number;
    private final Customer customer;

    // TODO: 2020/04/10 생성자의 패키지 액세스 포인트 추후 문서화
    /*package-accessed Constructor*/
    Table(final int number) {
        validate(number);
        this.number = number;
        customer = new Customer();
    }

    private void validate(int number) {
        if(number <= 0) {
            throw new IllegalTableException(number);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void order(Menu menu, int menuNumber) {
        customer.add(menu,menuNumber);
    }

    public Money calculate(Payment payment) {
        Money money = customer.calculateMoney();
        double discount = payment.getDiscount();
        return money.multiply(discount);
    }
}
