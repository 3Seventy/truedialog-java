package com.truedialog.client.model.keyword;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.ResourceStatus;
import com.truedialog.client.model.base.SoftDeletable;

/**
 * A reserved keyword.
 * <p>
 * Keywords provide a way for contacts to text into the system to initiate a campaign.
 * </p>
 *
 * @author Bryce Simonds
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class Keyword extends SoftDeletable // TODO: Is this really a SoftDeletable?
{
    /**
     * The account which owns this keyword.
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The channel this keyword is reserved on.
     */
    @JsonProperty("channel_id")
    private int channelId;

    /**
     * The campaign this keyword is currently attached to.
     * <p>
     * If this is NULL then the keyword is not attached to any campaign and will not generate a response.
     */
    @JsonProperty("campaign_id")
    private int campaignId;

    /**
     * The keyword name to reserve.
     * <p>
     * Keywords cannot contain spaces. Keywords are shared across a channel, so if someone else has a keyword of the
     * same name you will have to select a different keyword or use a different channel where it is not already
     * reserved.
     */
    @JsonProperty("name")
    private String name;

    /**
     * HACK: Mapping "status" to "StatusId".
     */
    @JsonProperty("Status")
    private int status;

    /**
     * Set if a callback should be generated on this keyword.
     */
    @JsonProperty("callback_required")
    private boolean callbackRequired;

    /**
     * Gets the key word status.
     *
     * @return the key word status
     */
    public ResourceStatus getStatus()
    {
        return ResourceStatus.resourceStatus(status);
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the account id.
     *
     * @return the account id
     */
    public int getAccountId()
    {
        return accountId;
    }

    /**
     * Sets the account id.
     *
     * @param accountId
     *            the new account id
     */
    public void setAccountId(int accountId)
    {
        this.accountId = accountId;
    }

    /**
     * Gets the channel id.
     *
     * @return the channel id
     */
    public int getChannelId()
    {
        return channelId;
    }

    /**
     * Sets the channel id.
     *
     * @param channelId
     *            the new channel id
     */
    public void setChannelId(int channelId)
    {
        this.channelId = channelId;
    }

    /**
     * Gets the campaign_id.
     *
     * @return the campaign_id
     */
    public int getCampaignId()
    {
        return campaignId;
    }

    /**
     * Sets the campaign_id.
     *
     * @param campaign_id
     *            the new campaign_id
     */
    public void setCampaignId(int campaign_id)
    {
        campaignId = campaign_id;
    }

    /**
     * Checks if is callback required.
     *
     * @return true, if is callback required
     */
    public boolean isCallbackRequired()
    {
        return callbackRequired;
    }

    /**
     * Sets the callback required.
     *
     * @param callbackRequired
     *            the new callback required
     */
    public void setCallbackRequired(boolean callbackRequired)
    {
        this.callbackRequired = callbackRequired;
    }
}

