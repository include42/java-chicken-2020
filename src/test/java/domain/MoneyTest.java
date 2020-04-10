package domain;

import exception.MoneyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @Test
    void Money_생성_테스트() {
        Money money = new Money(1000.0);

        Assertions.assertThat(money).hasFieldOrPropertyWithValue("money", 1000.0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -10.0, -200000.0})
    void Money_생성_예외처리_테스트(double source) {
        Assertions.assertThatThrownBy(() -> new Money(source))
                .isInstanceOf(MoneyException.class)
                .hasMessage("잘못된 금액을 입력하셨습니다.");
    }

    @ParameterizedTest
    @ValueSource(doubles = {100.0, 2000.0, 0.5})
    void Money_getter_테스트(double source) {
        Money money = new Money(source);

        Assertions.assertThat(money.getMoney()).isEqualTo(source);
    }

    @ParameterizedTest
    @CsvSource(value = {"100.0,2.0,200.0", "5.0, 0.1, 0.5"})
    void Money_곱셈_반환값_테스트(double source, double ratio, double expected) {
        Money money = new Money(source);

        Assertions.assertThat(money.multiply(ratio)).isEqualTo(new Money(expected));
    }
}
