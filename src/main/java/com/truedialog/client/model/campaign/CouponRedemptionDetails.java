package com.truedialog.client.model.campaign;

/**
 * Statics about a coupons redemption rates.
 */
public class CouponRedemptionDetails {
    /**
     * Total redemptions count
     */

    private int redemptionCount;

    /**
     * Count of redemptions performed too early
     */

    private int tooearlyCount;

    /**
     * Count of redemptions performed too late
     */

    private int toolateCount;

    /**
     * Count of redemptions over MaxUses count
     */

    private int toomanyCount;

    /**
     * Total bad redemptions count
     */

    private int totalbadCount;

    /**
     * First successful redemption
     */

    private CouponRedemption firstSuccessful;

    /**
     * Last successful redemption
     */

    private CouponRedemption lastSuccessful;

    public int getRedemptionCount() {
        return redemptionCount;
    }

    public void setRedemptionCount(int redemptionCount) {
        this.redemptionCount = redemptionCount;
    }

    public int getTooearlyCount() {
        return tooearlyCount;
    }

    public void setTooearlyCount(int tooearlyCount) {
        this.tooearlyCount = tooearlyCount;
    }

    public int getToolateCount() {
        return toolateCount;
    }

    public void setToolateCount(int toolateCount) {
        this.toolateCount = toolateCount;
    }

    public int getToomanyCount() {
        return toomanyCount;
    }

    public void setToomanyCount(int toomanyCount) {
        this.toomanyCount = toomanyCount;
    }

    public int getTotalbadCount() {
        return totalbadCount;
    }

    public void setTotalbadCount(int totalbadCount) {
        this.totalbadCount = totalbadCount;
    }

    public CouponRedemption getFirstSuccessful() {
        return firstSuccessful;
    }

    public void setFirstSuccessful(CouponRedemption firstSuccessful) {
        this.firstSuccessful = firstSuccessful;
    }

    public CouponRedemption getLastSuccessful() {
        return lastSuccessful;
    }

    public void setLastSuccessful(CouponRedemption lastSuccessful) {
        this.lastSuccessful = lastSuccessful;
    }
}