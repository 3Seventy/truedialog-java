package com.truedialog.client.model.report;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CampaignReportRow {
    /**
     * Account ID
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * Campaign ID
     */
    @JsonProperty("CampaignId")
    private int campaignId;

    /**
     * Campaign Name
     */
    @JsonProperty("CampaignName")
    private String campaignName;

    /**
     * Campaign created date
     */
    @JsonProperty("Created")
    private Date created;

    /**
     * Campaign type
     */
    @JsonProperty("CampaignTypeId")
    private int campaignTypeId;

    /**
     * Count of delivered messages
     */
    @JsonProperty("Delivered")
    private long delivered;

    /**
     * Count of undelivered messages
     */
    @JsonProperty("Undelivered")
    private long undelivered;

    /**
     * Count of unknown messages
     */
    @JsonProperty("Unknown")
    private long unknown;

    /**
     * Count of clicks
     */
    @JsonProperty("Clicks")
    private int clicks;

    /**
     * Count of total messages sent
     */
    @JsonProperty("TotalSent")
    private long totalSent;

    /**
     * Count of total messages received
     */
    @JsonProperty("TotalReceived")
    private long totalReceived;

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

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCampaignTypeId() {
        return campaignTypeId;
    }

    public void setCampaignTypeId(int campaignTypeId) {
        this.campaignTypeId = campaignTypeId;
    }

    public long getDelivered() {
        return delivered;
    }

    public void setDelivered(long delivered) {
        this.delivered = delivered;
    }

    public long getUndelivered() {
        return undelivered;
    }

    public void setUndelivered(long undelivered) {
        this.undelivered = undelivered;
    }

    public long getUnknown() {
        return unknown;
    }

    public void setUnknown(long unknown) {
        this.unknown = unknown;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public long getTotalSent() {
        return totalSent;
    }

    public void setTotalSent(long totalSent) {
        this.totalSent = totalSent;
    }

    public long getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(long totalReceived) {
        this.totalReceived = totalReceived;
    }
}