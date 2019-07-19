package com.truedialog.client.model.channel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.ChannelType;
import com.truedialog.client.enums.LanguageType;
import com.truedialog.client.model.base.Base;

/**
 * A channel that messages are sent out on.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class Channel extends Base {
    /**
     * The account that the channels belongs to.
     */
    @JsonProperty("AccountId")
    private int accountId;
    /**
     * Set if we can send handset verifications on.
     */
    @JsonProperty("AllowVerify")
    private boolean allowVerify;
    /**
     * Enumeration mapping for ChannelTypeId
     */
    @JsonIgnore
    private ChannelType channelType;
    /**
     * The default language type for a channel.
     */
    @JsonIgnore
    private LanguageType DefaultLanguage;
    /**
     * The default language type for a channel.
     */
    @JsonProperty("DefaultLanguageId")
    private int defaultLanguageId;

    @JsonProperty("description")
    private String description;
    /**
     * Set if the channel is currently active and running.
     */
    @JsonProperty("IsActive")
    private boolean isActive;

    /**
     * Set if the channel supports MMS.
     */
    @JsonProperty("IsMediaEnabled")
    private boolean isMediaEnabled;


    @JsonProperty("name")
    private String name;

    @JsonProperty("Label")
    private String label;

    /**
     * Set if this channel uses long codes or not.
     * Used to find out if we should pull a list of long codes when we push to the
     * channel ID or name instead of a specific long code.
     */

    @JsonProperty("UseLongCodes")
    private boolean UseLongCodes;


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public boolean isAllowVerify() {
        return allowVerify;
    }

    public void setAllowVerify(boolean allowVerify) {
        this.allowVerify = allowVerify;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public LanguageType getDefaultLanguage() {
        return DefaultLanguage;
    }

    public void setDefaultLanguage(LanguageType defaultLanguage) {
        DefaultLanguage = defaultLanguage;
    }

    public int getDefaultLanguageId() {
        return defaultLanguageId;
    }

    public void setDefaultLanguageId(int defaultLanguageId) {
        this.defaultLanguageId = defaultLanguageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isMediaEnabled() {
        return isMediaEnabled;
    }

    public void setMediaEnabled(boolean mediaEnabled) {
        isMediaEnabled = mediaEnabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isUseLongCodes() {
        return UseLongCodes;
    }

    public void setUseLongCodes(boolean useLongCodes) {
        UseLongCodes = useLongCodes;
    }
}