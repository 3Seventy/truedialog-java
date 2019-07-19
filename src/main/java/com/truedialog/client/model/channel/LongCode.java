package com.truedialog.client.model.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.SoftDeletable;

/**
 * Details for a long code
 */
public class LongCode extends SoftDeletable {
    /**
     * The account which owns this long code.
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The channel which handles this long code.
     */
    @JsonProperty("ChannelId")
    private int channelId;

    /**
     * The ANI for this long code.
     */
    @JsonProperty("Code")
    private String code;

    /**
     * Call Forwarding number
     */
    @JsonProperty("ForwardNumber")
    private String forwardNumber;

    /**
     * Random 6 digit Code that is sent in order to verify forwarding number
     */
    @JsonProperty("ForwardVerificationCode")
    private String forwardVerificationCode;

    /**
     * Status of call forwarding
     */
    @JsonProperty("ForwardStatus")
    private int forwardStatus;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getForwardNumber() {
        return forwardNumber;
    }

    public void setForwardNumber(String forwardNumber) {
        this.forwardNumber = forwardNumber;
    }

    public String getForwardVerificationCode() {
        return forwardVerificationCode;
    }

    public void setForwardVerificationCode(String forwardVerificationCode) {
        this.forwardVerificationCode = forwardVerificationCode;
    }

    public int getForwardStatus() {
        return forwardStatus;
    }

    public void setForwardStatus(int forwardStatus) {
        this.forwardStatus = forwardStatus;
    }
}