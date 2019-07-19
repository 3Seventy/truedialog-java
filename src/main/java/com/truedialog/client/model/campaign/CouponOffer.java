package com.truedialog.client.model.campaign;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.SoftDeletable;

/**
 * Holds details of coupon offer (used for landing page)
 */
public class CouponOffer extends SoftDeletable {
    /**
     * The account this offer belongs to
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The campaign this offer is for
     */
    @JsonProperty("CampaignId")
    private int campaignId;

    /**
     * Regular offer (without coupon)
     */
    @JsonProperty("RegularOffer")
    private String regularOffer;

    /**
     * Coupon offer (when coupon applied)
     */
    @JsonProperty("NewOffer")
    private String newOffer;

    /**
     * Offer image URL
     */
    @JsonProperty("ImageURL")
    private String imageURL;

    /**
     * Terms and conditions of this offer
     */
    @JsonProperty("TermsAndConditions")
    private String termsAndConditions;

    /**
     * URL to use as base when sending to user
     */
    @JsonProperty("UrlBase")
    private String urlBase;

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

    public String getRegularOffer() {
        return regularOffer;
    }

    public void setRegularOffer(String regularOffer) {
        this.regularOffer = regularOffer;
    }

    public String getNewOffer() {
        return newOffer;
    }

    public void setNewOffer(String newOffer) {
        this.newOffer = newOffer;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public String getUrlBase() {
        return urlBase;
    }

    public void setUrlBase(String urlBase) {
        this.urlBase = urlBase;
    }
}
