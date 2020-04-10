package domain.customer;

import domain.menu.Menu;
import domain.money.Money;
import exception.IllegalMenuException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private final List<Menu> menus;

    public Customer() {
        menus = new ArrayList<>();
    }

    public void add(Menu menu) {
        validate(menu);
        menus.add(menu);
    }

    private void validate(Menu menu) {
        if (Objects.isNull(menu)) {
            throw new IllegalMenuException();
        }
    }

    public Money calculateMoney() {
        int price = menus.stream()
                .map(Menu::getPrice)
                .map(Money::getMoney)
                .reduce(0, Integer::sum);
        return new Money(price);
    }

    public int getMenuSize() {
        return menus.size();
    }
}
