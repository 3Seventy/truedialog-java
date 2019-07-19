package com.truedialog.client.model.report;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

/**
 * Message log report row
 */
public class MessageReportRow {
    /**
     * ID
     */
    @JsonProperty("Id")
    private UUID id;

    /**
     * Account ID
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * Account Name
     */
    @JsonProperty("AccountName")
    private String accountName;

    /**
     * Campaign ID
     */
    @JsonProperty("CampaignId")
    private int campaignId;

    /**
     * True if sent, false if received
     */
    @JsonProperty("Sent")
    private boolean sent;

    /**
     * When message was sent
     */
    @JsonProperty("LogDate")
    private Date logDate;

    /**
     * Channel name
     */
    @JsonProperty("ChannelName")
    private String channelName;

    /**
     * Target phone number
     */
    @JsonProperty("Target")
    private String target;

    /**
     * Contact ID
     */
    @JsonProperty("ContactId")
    private int contactId;

    /**
     * Message
     */
    @JsonProperty("Message")
    private String message;

    /**
     * Delivery status ID
     */
    @JsonProperty("StatusId")
    private int statusId;

    /**
     * Action tied to this message
     */
    @JsonProperty("ActionId")
    private int actionId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }
}