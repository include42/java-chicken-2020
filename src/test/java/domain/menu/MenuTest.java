package domain.menu;

import domain.money.Money;
import exception.IllegalMenuException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class MenuTest {
    private int number;
    private String name;
    private Category category;
    private int price;

    @BeforeEach
    void init() {
        number = 1;
        name = "순살치킨";
        category = Category.CHICKEN;
        price = 1_000;
    }

    @Test
    void Menu_생성_테스트() {
        Menu menu = new Menu(number, name, category, price);

        Assertions.assertThat(menu).hasFieldOrPropertyWithValue("number", number);
        Assertions.assertThat(menu).hasFieldOrPropertyWithValue("name", name);
        Assertions.assertThat(menu).hasFieldOrPropertyWithValue("category", category);
        Assertions.assertThat(menu).hasFieldOrPropertyWithValue("price", new Money(price));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void Menu_생성_이름_예외_테스트(String invalidName) {
        Assertions.assertThatThrownBy(() -> new Menu(number, invalidName, category, price))
                .isInstanceOf(IllegalMenuException.class)
                .hasMessage("잘못된 메뉴를 입력하셨습니다.");
    }

    @Test
    void Menu_toString_테스트() {
        Menu menu = new Menu(number, name, category, price);

        Assertions.assertThat(menu.toString()).isEqualTo("[치킨] 1 - 순살치킨 : 1000원");
    }
}
