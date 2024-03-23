package core.basesyntax.model;

import core.basesyntax.exception.InvalidOperationException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getByCode(String code) {
        for (Operation operation: Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new InvalidOperationException("Invalid operation: " + code);
    }
}