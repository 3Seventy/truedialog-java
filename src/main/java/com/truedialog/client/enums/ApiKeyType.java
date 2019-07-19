package com.truedialog.client.enums;

public enum ApiKeyType {

    MASTER(1),

    COMMON(2),

    TEMPORARY(3);


    private int value;

    ApiKeyType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ApiKeyType apiKeyType(int value) {
        switch (value) {
            case 1:
                return MASTER;
            case 2:
                return COMMON;
            case 3:
                return TEMPORARY;
        }
        return null;
    }
}
