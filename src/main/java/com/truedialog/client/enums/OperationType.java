package com.truedialog.client.enums;


public enum OperationType {

    GREATER_THAN(0),

    LESS_THEN(1),

    GREATER_THAN_OR_EQUAL(2),

    LESS_THAN_OR_EQUAL(3),

    NOT_EQUAL(4),

    EQUAL(5),

    LIKE(6),

    ANY_BITS(7),

    ALL_BITS(8),

    NO_BITS(9),

    BEGINS_WITH(10),

    ENDS_WITH(11),

    NONE(12);

    private int value;

    OperationType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
