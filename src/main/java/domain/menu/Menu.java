package domain.menu;

import domain.money.Money;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final Money price;

    // TODO: 2020/04/10 생성자를 팩토리에서만 참조하도록 접근제어자 수정함. 이에 대한 상세한 문서화주석 추가할것!!
    /*package-accessed Constructor*/
    Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = new Money(price);
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    public int getNumber() {
        return number;
    }
}
