package com.truedialog.client.enums;


public enum FilterType {

    DYNAMIC_ATTRIBUTE(1),

    SUBSCRIPTION(2),

    CONTACT(3),

    ACCOUNT_ATTRIBUTE(4),

    KEYWORD(5);

    private int value;

    FilterType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FilterType filterType(int filterType) {

        switch (filterType) {
            case 1:
                return DYNAMIC_ATTRIBUTE;
            case 2:
                return SUBSCRIPTION;
            case 3:
                return CONTACT;
            case 4:
                return ACCOUNT_ATTRIBUTE;
            case 5:
                return KEYWORD;
            default:
                return null;
        }

    }
}
