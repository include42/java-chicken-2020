package domain.customer;

import domain.menu.MenuRepository;
import domain.money.Money;
import exception.IllegalMenuException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CustomerTest {
    // TODO: 2020/04/10 메뉴의 종류가 바뀔 수 있는데, 그렇기 때문에 이 코드는 도메인에 종속적인 테스트코드임. 내용 전체를 추후 개선 예정.
    @Test
    void Customer_생성_테스트() {
        Customer customer = new Customer();

        Assertions.assertThat(customer).isNotNull();
    }

    @Test
    void Customer_add_테스트() {
        Customer customer = new Customer();

        customer.add(MenuRepository.valueOf(1),1);
        customer.add(MenuRepository.valueOf(2), 2);
        customer.add(MenuRepository.valueOf(2), 3);

        Assertions.assertThat(customer.getMenuSize()).isEqualTo(6);
    }

    @Test
    void Customer_add_null_예외_테스트() {
        Customer customer = new Customer();

        Assertions.assertThatThrownBy(() -> customer.add(null, 10))
                .isInstanceOf(IllegalMenuException.class)
                .hasMessage("잘못된 메뉴를 입력하셨습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -10000})
    void Customer_add_개수_예외_테스트(int number) {
        Customer customer = new Customer();

        Assertions.assertThatThrownBy(() -> customer.add(MenuRepository.valueOf(1), number))
                .isInstanceOf(IllegalMenuException.class)
                .hasMessage("잘못된 메뉴를 입력하셨습니다.");
    }

    @Test
    void Customer_calculate_테스트() {
        Customer customer = new Customer();

        customer.add(MenuRepository.valueOf(1), 1);
        customer.add(MenuRepository.valueOf(2), 2);

        Assertions.assertThat(customer.calculateMoney()).isEqualTo(new Money(48000));
    }

    @Test
    void Customer_calculate_10개이상_할인_테스트() {
        Customer customer = new Customer();

        customer.add(MenuRepository.valueOf(1), 10);
        customer.add(MenuRepository.valueOf(2), 20);

        Assertions.assertThat(customer.calculateMoney()).isEqualTo(new Money(450000));
    }
}
