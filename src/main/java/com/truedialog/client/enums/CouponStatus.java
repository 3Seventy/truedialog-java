package com.truedialog.client.enums;

/**
 * The status of the coupon.
 */
public enum CouponStatus {
    /**
     * The coupon has been redeemed
     */
    REDEEMED(0),

    /**
     * The coupon code was not found
     */
    NOTFOUND(1),

    /**
     * The coupon has expired
     */
    EXPIRED(2),

    /**
     * The number of times this coupon can be used has been reached.
     */
    LIMIT_REACHED(3),

    /**
     * The coupon is not yet valid.
     */
    NOT_STARTED(4);

    private int value;

    CouponStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CouponStatus couponStatus(int value) {
        switch (value) {
            case 0:
                return REDEEMED;
            case 1:
                return NOTFOUND;
            case 2:
                return EXPIRED;
            case 3:
                return LIMIT_REACHED;
            case 4:
                return NOT_STARTED;
            default:
                return null;
        }
    }

}