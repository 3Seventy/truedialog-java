package com.truedialog.client.model.action;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.CampaignType;
import com.truedialog.client.enums.ChannelType;
import com.truedialog.client.enums.ScheduleType;
import com.truedialog.client.model.base.BaseAudited;
import com.truedialog.client.model.campaign.Campaign;
import com.truedialog.client.model.contact.Contact;
import com.truedialog.client.model.subscription.Subscription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Used for sending a campaign to a list of contacts. Note that the list of contacts can be specified in a variety of
 * ways: Targets: This is a list of phone numbers and/or email addresses. Contacts: This is a list of contact ids.
 * ContactListId: This is the ID of a contact list which runs on the 3Seventy servers. All three types can be specified
 * and the lists will be merged with duplicate contacts removed.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class ActionPushCampaign extends BaseAudited {

    @JsonProperty("AccountId")
    private int accountId;

    @JsonProperty("Channels")
    private List<String> channels = new ArrayList<>();

    @JsonProperty("RoundRobinById")
    private boolean roundRobinById;

    @JsonProperty("Targets")
    private List<String> targets = new ArrayList<String>();

    @JsonProperty("TargetsUrl")
    private String targetsUrl;

    @JsonProperty("TargetsColumn")
    private String targetsColumn;

    @JsonProperty("ContactListIds")
    private List<Integer> contactListIds = new ArrayList<Integer>();

    @JsonProperty("ExcludeListIds")
    private List<Integer> excludeListIds = new ArrayList<>();

    @JsonProperty("CampaignId")
    private int campaignId;

    @JsonProperty("IgnoreSingleUse")
    private boolean ignoreSingleUse;

    @JsonProperty("ForceOptIn")
    private boolean forceOptIn;

    @JsonProperty("Execute")
    private boolean execute;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("MediaId")
    private int mediaId;

    @JsonProperty("From")
    private String from;

    @JsonProperty("Subject")
    private String subject;


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * @return The channels the campaign will be (or was) sent to.
     */
    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    /**
     * @return The contact lists to use for getting a list of contacts.
     * <p>
     * Generation of contact lists are not yet supported by this SDK, but they can be created via
     * raw API calls and using our Portal.  If you do create a contact list in this way, you can
     * supply the generated ID here without any issues.
     * </p>
     */
    public List<Integer> getContactListIds() {
        return contactListIds;
    }

    public void setContactListIds(List<Integer> contactListIds) {
        this.contactListIds = contactListIds;
    }

    /**
     * Gets the list of targets that event will be (or was) sent to.
     *
     * <p>
     * Targets can be a mixture of email addresses, phone numbers, and {@link Contact} ids.
     * </p>
     *
     * <p>
     * Note that in order for the system to differentiate a phone number from a contact ID, phone numbers must be
     * prefixed with their country dialing code. E.g.: {@code (221) 555-0100} should be listed as {@code +12215550100}
     * </p>
     */
    public List<String> getTargets() {
        return targets;
    }

    /**
     * Sets the list of targets that event will be (or was) sent to.
     *
     * <p>
     * Targets can be a mixture of email addresses, phone numbers, and {@link Contact} ids.
     * </p>
     *
     * <p>
     * Note that in order for the system to differentiate a phone number from a contact ID, phone numbers must be
     * prefixed with their country dialing code. E.g.: {@code (221) 555-0100} should be listed as {@code +12215550100}
     * </p>
     *
     * @param targets The list of targets to set.
     */
    public void setTargets(List<String> targets) {
        this.targets = (targets == null) ? new ArrayList<String>() : targets;
    }

    /**
     * Gets the {@link Campaign} ID that will be sent out.
     *
     * <p>
     * For {@link CampaignType#GATEWAY GATEWAY} campaigns the
     * {@link ActionPushCampaign#setMessage(String) message} field is required.
     * </p>
     */
    public int getCampaignId() {
        return campaignId;
    }

    /**
     * Sets the {@link Campaign} ID that will be sent out.
     *
     * <p>
     * For {@link CampaignType#GATEWAY GATEWAY} campaigns the
     * {@link ActionPushCampaign#setMessage(String) message} field is required.
     * </p>
     *
     * @param campaignId The campaign ID to set.
     */
    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    /**
     * Gets the "from" line used for sending to email channels.
     *
     * <p>
     * If it is not filled in, a default from field will be used.
     * </p>
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the "from" line to use for sending to email channels.
     *
     * <p>
     * If it is not filled in, a default from field will be used.
     * </p>
     *
     * @param from The value to use in the "from" line.
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets if the event is ignoring a {@link Campaign Campaign's} SingleUse flag.
     *
     * <p>
     * If a campaign is marked as single use, then it will only get sent to a particular contact once and only once.
     * Setting this value will force the message to get sent regardless of the SingleUse flag setting on the campaign.
     * </p>
     * <p>
     * This can be handy if you have a particular contact who did not receive the message and you would like to resend
     * it to them.
     * </p>
     *
     * @see Campaign#isSingleUse()
     */
    public boolean isIgnoreSingleUse() {
        return ignoreSingleUse;
    }

    /**
     * Sets if the event should ignore the {@link Campaign Campaign's} SingleUse flag.
     *
     * <p>
     * If a campaign is marked as single use, then it will only get sent to a particular contact once and only once.
     * Setting this value will force the message to get sent regardless of the SingleUse flag setting on the campaign.
     * </p>
     * <p>
     * This can be handy if you have a particular contact who did not receive the message and you would like to resend
     * it to them.
     * </p>
     *
     * @param ignoreSingleUse The new value for IgnoreSingleUse flag.
     * @see Campaign#isSingleUse()
     */
    public void setIgnoreSingleUse(boolean ignoreSingleUse) {
        this.ignoreSingleUse = ignoreSingleUse;
    }

    /**
     * Gets if the event will force a contact to be opted into the {@link Campaign Campaign's} {@link Subscription}.
     */
    public boolean isForceOptIn() {
        return forceOptIn;
    }

    /**
     * Sets if the event will force opt ins during the push.
     *
     * @param forceOptIn Sets the new ForceOptIn flag.
     */
    public void setForceOptIn(boolean forceOptIn) {
        this.forceOptIn = forceOptIn;
    }


    public boolean isExecute() {
        return execute;
    }

    /**
     * Set true if the action should be executed on creation
     */
    public void setExecute(boolean execute) {
        this.execute = execute;
    }

    /**
     * Gets the message text that was sent for a {@link CampaignType#GATEWAY GATEWAY}
     * campaign.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message text for use on {@link CampaignType#GATEWAY GATEWAY} campaigns.
     *
     * <p>
     * <strong>IMPORTANT:</strong> You cannot send Razor formatted text with this system.
     * </p>
     *
     * @param message The text to send.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the "Subject" line to use when sending to an email channel.
     *
     * <p>
     * This field is ignored when being sent to any channel type but
     * {@link ChannelType#EMAIL EMAIL}.
     * </p>
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the "Subject" line to use when sending to an email channel.
     *
     * <p>
     * This field is ignored when being sent to any channel type but
     * {@link ChannelType#EMAIL EMAIL}.
     * </p>
     *
     * @param subject The new "Subject" line to use for emails.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }


    /**
     * @return id of the media to be attached
     */
    public int getMediaId() {
        return mediaId;
    }

    /**
     * @param mediaId id of the media file to be attached
     */
    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public boolean isRoundRobinById() {
        return roundRobinById;
    }

    public void setRoundRobinById(boolean roundRobinById) {
        this.roundRobinById = roundRobinById;
    }

    public String getTargetsUrl() {
        return targetsUrl;
    }

    public void setTargetsUrl(String targetsUrl) {
        this.targetsUrl = targetsUrl;
    }

    public String getTargetsColumn() {
        return targetsColumn;
    }

    public void setTargetsColumn(String targetsColumn) {
        this.targetsColumn = targetsColumn;
    }

    public List<Integer> getExcludeListIds() {
        return excludeListIds;
    }

    public void setExcludeListIds(List<Integer> excludeListIds) {
        this.excludeListIds = excludeListIds;
    }
}
