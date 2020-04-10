package domain.customer;

import domain.menu.Category;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.money.Money;
import exception.IllegalMenuException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Customer {
    private final Map<Menu, Integer> menus;

    public Customer() {
        menus = new HashMap<>();
        for(Menu menu : MenuRepository.menus()) {
            menus.put(menu, 0);
        }
    }

    public void add(Menu menu, int number) {
        validate(menu, number);
        number += menus.get(menu);
        menus.put(menu, number);
    }

    private void validate(Menu menu, int number) {
        if (Objects.isNull(menu) || number <= 0) {
            throw new IllegalMenuException();
        }
    }

    public Money calculateMoney() {
        int price = menus.keySet()
                .stream()
                .map(this::calculateEachMenu)
                .mapToInt(Money::getMoney)
                .reduce(0,Integer::sum);
        return new Money(price);
    }

    // TODO: 2020/04/10 추후 할인부분은 리팩토링 예정
    private Money calculateEachMenu(Menu menu) {
        Money price = menu.getPrice();
        int number = menus.get(menu);

        price = price.multiply(number);
        if(menu.isChicken() && number >= 10) {
            return price.subtract(10000 * (number / 10));
        }
        return price;
    }

    public int getMenuSize() {
        return menus.values()
                .stream()
                .reduce(0,Integer::sum);
    }
}
