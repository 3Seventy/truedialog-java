package com.truedialog.client.model.campaign;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.CouponStatus;

import java.util.Date;

/**
 * Returned details of a redeemed coupon
 */
public class CouponRedemption {

    @JsonIgnore
    private int couponStatusId;

    /**
     * The campaign for which the coupon was defined under.
     */
    @JsonProperty("CampaignId")
    private int campaignId;

    /**
     * The customer who attempted to redeem the coupon.
     */
    @JsonProperty("ContactId")
    private int contactId;

    /**
     * The actual code submitted for redemption
     */
    @JsonProperty("CouponCode")
    private String couponCode;

    /**
     * The status of the redemption attempt.
     * <p>
     * Non zero means failure.
     * </p>
     */
    private CouponStatus couponStatus;

    /**
     * When this coupon redemption was created
     */
    @JsonProperty("Created")
    private Date created;

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public CouponStatus getCouponStatus() {
        return CouponStatus.couponStatus(couponStatusId);
    }

    public void setCouponStatus(CouponStatus couponStatus) {
        couponStatusId = couponStatus.getValue();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
