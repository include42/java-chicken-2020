package domain.money;

import exception.MoneyException;

import java.util.Objects;

public class Money {
    int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money <= 0) {
            throw new MoneyException();
        }
    }

    public int getMoney() {
        return money;
    }

    public Money multiply(int operand) {
        return new Money(money * operand);
    }

    public Money subtract(int operand) {
        return new Money(money - operand);
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
