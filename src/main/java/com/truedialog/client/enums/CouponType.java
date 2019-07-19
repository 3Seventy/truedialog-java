package com.truedialog.client.enums;

/**
 * Type of coupon
 */
public enum CouponType {
    /**
     * Static Coupons
     */
    STATIC(0),

    /**
     * Dynamically Generated Coupons
     */
    DYNAMIC(1),

    /**
     * Coupon codes generated externally and uploaded
     */
    EXTERNAL(2);

    private int value;

    CouponType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CouponType couponType(int value) {
        switch (value) {
            case 0:
                return STATIC;
            case 1:
                return DYNAMIC;
            case 2:
                return EXTERNAL;
            default:
                return null;
        }
    }
}