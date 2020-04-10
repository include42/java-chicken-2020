package domain;

import exception.IllegalUserInputException;

import java.util.Arrays;

public enum Operation {
    ORDER("1"),
    PAY("2"),
    TERMINATE("3");

    private final String key;

    Operation(String key) {
        this.key = key;
    }

    public static Operation createOperationByKey(String key) {
        return Arrays.stream(values())
                .filter(operation -> operation.key.equals(key))
                .findFirst()
                .orElseThrow(IllegalUserInputException::new);
    }
}
