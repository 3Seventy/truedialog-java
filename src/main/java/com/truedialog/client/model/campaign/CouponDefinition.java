package com.truedialog.client.model.campaign;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.CouponType;
import com.truedialog.client.enums.ValidDateType;

import java.util.Date;

/**
 * Coupon definition
 */
public class CouponDefinition {

    public CouponDefinition() {
        maxUses = 1; // Default to one use per customer.

        // Some sane defails to help prevent 500 errors when inserting into DB.
        prefix = "";
        staticCode = "";
        name = "";
        description = "";
    }

    /**
     * Account this coupon belongs to
     */

    @JsonProperty("AccountId")
    private int accountId;

    /**
     * Campaign this coupon belongs to
     */

    @JsonProperty("CampaignId")
    private int campaignId;

    /**
     * The type of coupon that's being defined, Static or Dynamic. (REQUIRED)
     */

    @JsonProperty("CouponTypeId")
    private int couponTypeId;

    /**
     * The prefix code for the coupon. (OPTIONAL)
     */

    @JsonProperty("Prefix")
    private String prefix;

    /**
     * The static code for the coupon.
     *
     * <p>This field is required if the coupon type is Static</p>
     */

    @JsonProperty("StaticCode")
    private String staticCode;

    /**
     * A user definable ID value. (OPTIONAL)
     */

    @JsonProperty("ExternalId1")
    private String externalId1;

    /**
     * A second user definable ID value. (OPTIONAL)
     */

    @JsonProperty("ExternalId2")
    private String externalId2;

    /**
     * The date we should start allowing coupons to be redeemed. (OPTIONAL)
     *
     * <p>NULL indicates no start date.  I.e. accept immediately.</p>
     */

    @JsonProperty("ValidFrom")
    private Date validFrom;

    /**
     * THe date we should stop allowing coupons to be redeemed. (OPTIONAL)
     *
     * <p>NULL indicates no expiration date.</p>
     */

    @JsonProperty("ValidTo")
    private Date validTo;

    /**
     * The maximum number of allowed uses per customer. (OPTIONAL)
     *
     * <p>Zero indicates that there is no maximum.  Default is 1 if not specified.</p>
     */

    @JsonProperty("MaxUses")
    private int maxUses;

    /**
     * Coupon Code valid DateTypeId i.e. None or Static or Rolling (OPTIONAL)
     */

    @JsonProperty("ValidDateTypeId")
    private int validDateTypeId;

    /**
     * Number of days that coupon code is valid for the Rolling date type Coupon Code
     * <p>
     * This property is required if ValidDateType is Rolling
     * </p>
     */
    @JsonProperty("ValidRollingDays")
    private int validRollingDays;

    /**
     * Rolling offset days of the coupon code
     *
     * <p>This property is required if ValidDateType is Rolling</p>
     */

    @JsonProperty("ValidRollingOffSet")
    private int validRollingOffSet;

    /**
     * External Coupon List Id value
     *
     * <p>Either ExternalListId or ExternalCouponList is Required if the CouponType is External</p>
     */

    @JsonProperty("ExternalListId")
    private int externalListId;

    /**
     * External Coupon List details
     *
     * <p>Either ExternalCouponList or ExternalListId is Required if the CouponType is External</p>
     */

    @JsonProperty("ExternalCouponList")
    private ExternalCouponList externalCouponList;


    /**
     * User definable name for this coupon. (OPTIONAL)
     */

    @JsonProperty("Name")
    private String name;

    /**
     * User definable coupon description. (OPTIONAL)
     */

    @JsonProperty("Description")
    private String description;

    /**
     * Enumeration mapping for CouponTypeId
     */

    public CouponType getCouponType() {
        return CouponType.couponType(couponTypeId);
    }

    public void setCouponType(CouponType couponType) {
        this.couponTypeId = couponType.getValue();
    }


    /**
     * Enumeration mapping for ValidDateTypeId
     */
    @JsonIgnore
    public ValidDateType getValidDateType() {
        return ValidDateType.validDateType(validDateTypeId);
    }

    public void setValidDateType(ValidDateType validDateType) {
        this.validDateTypeId = validDateType.getValue();
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getCouponTypeId() {
        return couponTypeId;
    }

    public void setCouponTypeId(int couponTypeId) {
        this.couponTypeId = couponTypeId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getStaticCode() {
        return staticCode;
    }

    public void setStaticCode(String staticCode) {
        this.staticCode = staticCode;
    }

    public String getExternalId1() {
        return externalId1;
    }

    public void setExternalId1(String externalId1) {
        this.externalId1 = externalId1;
    }

    public String getExternalId2() {
        return externalId2;
    }

    public void setExternalId2(String externalId2) {
        this.externalId2 = externalId2;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public void setMaxUses(int maxUses) {
        this.maxUses = maxUses;
    }

    public int getValidDateTypeId() {
        return validDateTypeId;
    }

    public void setValidDateTypeId(int validDateTypeId) {
        this.validDateTypeId = validDateTypeId;
    }

    public int getValidRollingDays() {
        return validRollingDays;
    }

    public void setValidRollingDays(int validRollingDays) {
        this.validRollingDays = validRollingDays;
    }

    public int getValidRollingOffSet() {
        return validRollingOffSet;
    }

    public void setValidRollingOffSet(int validRollingOffSet) {
        this.validRollingOffSet = validRollingOffSet;
    }

    public int getExternalListId() {
        return externalListId;
    }

    public void setExternalListId(int externalListId) {
        this.externalListId = externalListId;
    }

    public ExternalCouponList getExternalCouponList() {
        return externalCouponList;
    }

    public void setExternalCouponList(ExternalCouponList externalCouponList) {
        this.externalCouponList = externalCouponList;
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
}