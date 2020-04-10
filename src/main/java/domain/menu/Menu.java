package domain.menu;

import domain.money.Money;
import exception.IllegalMenuException;

import java.util.Objects;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final Money price;

    // TODO: 2020/04/10 생성자를 팩토리에서만 참조하도록 접근제어자 수정함. 이에 대한 상세한 문서화주석 추가할것!!
    // TODO: 2020/04/10 number는 어차피 MenuRepository에서 체크, Enum인 category와 int인 price는 생략. 이름만 검사함. 문서화 할것.
    /*package-accessed Constructor*/
    Menu(final int number, final String name, final Category category, final int price) {
        validate(name);
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = new Money(price);
    }

    private void validate(String name) {
        if(Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalMenuException();
        }
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price.getMoney() + "원";
    }

    public int getNumber() {
        return number;
    }

    public Money getPrice() {
        return price;
    }

    public boolean isChicken() {
        return category.equals(Category.CHICKEN);
    }

    public String getName() {
        return name;
    }
}
