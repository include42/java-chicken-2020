package domain;

import exception.MoneyException;

import java.util.Objects;

public class Money {
    double money;

    public Money(double money) {
        validate(money);
        this.money = money;
    }

    private void validate(double money) {
        if (money <= 0) {
            throw new MoneyException();
        }
    }

    public double getMoney() {
        return money;
    }

    public Money multiply(double ratio) {
        return new Money(money * ratio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Double.compare(money1.money, money) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
