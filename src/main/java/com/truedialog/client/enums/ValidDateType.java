package com.truedialog.client.enums;

public enum ValidDateType {
    /**
     * Coupon Code with no FROM and TO dates.
     */
    NONE(0),

    /**
     * Coupon Code with static FROM and TO dates.
     */
    STATIC(1),

    /**
     * Coupon Code with rolling FROM and TO dates.
     */
    ROLLING(2);

    private int value;

    ValidDateType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ValidDateType validDateType(int value) {
        switch (value) {
            case 1:
                return NONE;
            case 2:
                return STATIC;
            case 3:
                return ROLLING;
            default:
                return null;
        }
    }
}
