package domain.table;

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

    public Payment findPaymentByKey(String key) {
        return Arrays.stream(values())
                .filter(payment -> payment.key.equals(key))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        // TODO: 2020/04/10 예외처리 나중에 따로 만들 예정...
    }
    public double getDiscount() {
        return discount;
    }
}
