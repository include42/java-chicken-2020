package domain.table;

import exception.IllegalUserInputException;

import java.util.Arrays;

public enum Payment {
    CARD("1", 1.0),
    BILL("2", 0.9);

    private final String key;
    private final double discount;

    Payment(String key, double discount) {
        this.key = key;
        this.discount = discount;
    }

    public static Payment findPaymentByKey(String key) {
        return Arrays.stream(values())
                .filter(payment -> payment.key.equals(key))
                .findFirst()
                .orElseThrow(IllegalUserInputException::new);
    }
    public double getDiscount() {
        return discount;
    }
}
