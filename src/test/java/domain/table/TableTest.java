package domain.table;

import domain.menu.MenuRepository;
import domain.money.Money;
import exception.IllegalMenuException;
import exception.IllegalTableException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TableTest {
    @Test
    void Table_생성_테스트() {
        Table table = new Table(1);

        Assertions.assertThat(table).hasFieldOrPropertyWithValue("number", 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -1000})
    void Table_생성_예외_테스트(int number){
        Assertions.assertThatThrownBy(() -> new Table(number))
                .isInstanceOf(IllegalTableException.class)
                .hasMessage(String.format("잘못된 테이블 번호를 입력하셨습니다. 입력 : %d", number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 200})
    void Table_toString_테스트(int number) {
        Table table = new Table(number);

        Assertions.assertThat(table.toString()).isEqualTo(Integer.toString(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 100, 2147483647})
    void Table_order_예외_테스트(int number) {
        Table table = new Table(1);

        Assertions.assertThatThrownBy(() -> table.order(MenuRepository.valueOf(1),number))
                .isInstanceOf(IllegalMenuException.class)
                .hasMessage("잘못된 메뉴를 입력하셨습니다.");
    }

    @Test
    void Table_calculate_테스트() {
        Table table = new Table(1);

        table.order(MenuRepository.valueOf(1),5);
        table.order(MenuRepository.valueOf(2),3);

        Assertions.assertThat(table.calculate(Payment.CARD).getMoney()).isEqualTo(128_000);
    }

    @Test
    void Table_calculate_현금할인_테스트() {
        Table table = new Table(1);

        table.order(MenuRepository.valueOf(1),5);
        table.order(MenuRepository.valueOf(2),3);

        Assertions.assertThat(table.calculate(Payment.BILL).getMoney()).isEqualTo(115_200);
    }
}
