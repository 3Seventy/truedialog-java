package com.truedialog.client.model.campaign;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.Base;

import java.util.List;

/**
 * External coupon list
 */
public class ExternalCouponList extends Base {
    /**
     * The account ID that external coupon list belongs to
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * Name of the external coupon list
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Description for the external coupon list
     */
    @JsonProperty("Description")
    private String description;

    /**
     * external coupon list can be shared with the child accounts or not
     */
    @JsonProperty("Inheritable")
    private boolean inheritable;

    /**
     * Total number of codes available
     */
    @JsonProperty("TotalCodesAvailable")
    private int totalCodesAvailable;

    /**
     * A list of coupon codes
     */
    @JsonProperty("CouponCodes")
    private List<String> couponCodes;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInheritable() {
        return inheritable;
    }

    public void setInheritable(boolean inheritable) {
        this.inheritable = inheritable;
    }

    public int getTotalCodesAvailable() {
        return totalCodesAvailable;
    }

    public void setTotalCodesAvailable(int totalCodesAvailable) {
        this.totalCodesAvailable = totalCodesAvailable;
    }

    public List<String> getCouponCodes() {
        return couponCodes;
    }

    public void setCouponCodes(List<String> couponCodes) {
        this.couponCodes = couponCodes;
    }
}