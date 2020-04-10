package domain.menu;

import exception.IllegalMenuException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuRepositoryTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void MenuRepository_valueOf_테스트(int number) {
        Assertions.assertThat(MenuRepository.valueOf(number)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 72, 424242})
    void MenuRepository_valueOf_예외_테스트(int number) {
        Assertions.assertThatThrownBy(() -> MenuRepository.valueOf(number))
                .isInstanceOf(IllegalMenuException.class)
                .hasMessage("잘못된 메뉴를 입력하셨습니다.");
    }

    @Test
    void MenuRepository_menus_수행_테스트() {
        // TODO: 2020/04/10 이 부분의 테스트는, 메뉴의 구성이 바뀔 수 있으므로 비어있는지만 검사했음. 추후 개선
        Assertions.assertThat(MenuRepository.menus()).isNotEmpty();
    }
}
