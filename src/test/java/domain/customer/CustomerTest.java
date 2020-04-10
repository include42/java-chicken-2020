package domain.customer;

import domain.menu.MenuRepository;
import domain.money.Money;
import exception.IllegalMenuException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    void Customer_생성_테스트() {
        Customer customer = new Customer();

        Assertions.assertThat(customer).isNotNull();
    }

    @Test
    void Customer_add_테스트() {
        Customer customer = new Customer();

        customer.add(MenuRepository.valueOf(1));
        customer.add(MenuRepository.valueOf(2));
        customer.add(MenuRepository.valueOf(2));

        Assertions.assertThat(customer.getMenuSize()).isEqualTo(3);
    }

    @Test
    void Customer_add_예외_테스트() {
        Customer customer = new Customer();

        Assertions.assertThatThrownBy(() -> customer.add(null))
                .isInstanceOf(IllegalMenuException.class)
                .hasMessage("잘못된 메뉴를 입력하셨습니다.");
    }

    @Test
    void Customer_calculate_테스트() {
        Customer customer = new Customer();

        customer.add(MenuRepository.valueOf(1));
        customer.add(MenuRepository.valueOf(2));

        Assertions.assertThat(customer.calculateMoney()).isEqualTo(new Money(32000));
    }
}
