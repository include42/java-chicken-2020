package domain.menu;

import exception.IllegalMenuException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuRepositoryTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void valueOf_테스트(int number) {
        Assertions.assertThat(MenuRepository.valueOf(number)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 72, 424242})
    void valueOf_예외_테스트(int number) {
        Assertions.assertThatThrownBy(() -> MenuRepository.valueOf(number))
                .isInstanceOf(IllegalMenuException.class)
                .hasMessage("잘못된 메뉴를 입력하셨습니다.");
    }
}
