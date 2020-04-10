package domain.money;

import domain.money.Money;
import exception.MoneyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @Test
    void Money_생성_테스트() {
        Money money = new Money(1000);

        Assertions.assertThat(money).hasFieldOrPropertyWithValue("money", 1000);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -10, -200000})
    void Money_생성_예외처리_테스트(int source) {
        Assertions.assertThatThrownBy(() -> new Money(source))
                .isInstanceOf(MoneyException.class)
                .hasMessage("잘못된 금액을 입력하셨습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 2000, 2147483647})
    void Money_getter_테스트(int source) {
        Money money = new Money(source);

        Assertions.assertThat(money.getMoney()).isEqualTo(source);
    }

    @ParameterizedTest
    @CsvSource(value = {"100,2,200", "5, 1, 5"})
    void Money_곱셈_반환값_테스트(int source, int operand, int expected) {
        Money money = new Money(source);

        Assertions.assertThat(money.multiply(operand)).isEqualTo(new Money(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"100,50,50", "5, 4, 1"})
    void Money_뺄셈_반환값_테스트(int source, int operand, int expected) {
        Money money = new Money(source);

        Assertions.assertThat(money.subtract(operand)).isEqualTo(new Money(expected));
    }
}
