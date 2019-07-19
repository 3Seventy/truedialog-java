package com.truedialog.client.model.content;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.ChannelType;
import com.truedialog.client.enums.EncodingType;
import com.truedialog.client.enums.LanguageType;
import com.truedialog.client.model.account.Account;
import com.truedialog.client.model.base.BaseAudited;
import com.truedialog.client.model.channel.Channel;

/**
 * A specific content template descriptor.
 * <p>
 * Templates hold the actual content that get sent to your contacts.
 * </p>
 *
 * @author Bryce Simonds
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class ContentTemplate extends BaseAudited
{
    @JsonProperty("AccountId")
    private Integer accountId;

    @JsonProperty("ContentId")
    private Integer contentId;

    @JsonProperty("LanguageId")
    private int languageId;

    @JsonProperty("ChannelTypeId")
    private int channelTypeId;

    @JsonProperty("EncodingTypeId")
    private int encodingTypeId;

    @JsonProperty("Template")
    private String template;

    /**
     * Gets the {@link Account#getId() Account ID} which owns this template.
     *
     * @return
     */
    public int getAccountId()
    {
        return accountId;
    }

    /**
     * Sets the {@link Account} ID which owns this template.
     *
     * @param accountId
     *            The new account ID to use.
     */
    public void setAccountId(int accountId)
    {
        this.accountId = accountId;
    }

    /**
     * Gets the {@link Content} ID which groups this template with others.
     */
    public int getContentId()
    {
        return contentId;
    }

    /**
     * Sets the {@link Content} ID which groups this template with others.
     *
     * @param contentId
     *            The new Content ID to use.
     */
    public void setContentId(int contentId)
    {
        this.contentId = contentId;
    }

    /**
     * Gets the {@link LanguageType} ID this template is in.
     *
     * @see ContentTemplate#getLanguage() getLanguage()
     */
    public int getLanguageId()
    {
        return languageId;
    }

    /**
     * Sets the {@link LanguageType} ID this template is in.
     *
     * @param languageId
     *            The new {@link LanguageType} ID for this template.
     *
     * @see ContentTemplate#setLanguage(LanguageType) setLanguage(LanguageType)
     */
    public void setLanguageId(int languageId)
    {
        this.languageId = languageId;
    }

    /**
     * Gets the type of {@link Channel} this template is intended to be sent on.
     *
     * @see ContentTemplate#getChannelType() getChannelType()
     * @see ChannelType
     */
    public int getChannelTypeId()
    {
        return channelTypeId;
    }

    /**
     * Sets the type of {@link Channel} this template is tended to be sent on.
     *
     * @param channelTypeId
     *            The new {@link ChannelType} ID to use.
     *
     * @see ContentTemplate#setChannelType(ChannelType) setChannelType(ChannelType)
     * @see ChannelType
     */
    public void setChannelTypeId(int channelTypeId)
    {
        this.channelTypeId = channelTypeId;
    }

    /**
     * Gets the format of the template data.
     *
     * @see ContentTemplate#getEncodingType() getEncodingType()
     * @see EncodingType
     */
    public int getEncodingTypeId()
    {
        return encodingTypeId;
    }

    /**
     * Sets the format of the template data.
     *
     * @param encodingTypeId
     *            The new {@link EncodingType} ID to use.
     *
     * @see ContentTemplate#setEncodingType(EncodingType) setEncodingType(EncodingType)
     * @see EncodingType
     */
    public void setEncodingTypeId(int encodingTypeId)
    {
        this.encodingTypeId = encodingTypeId;
    }

    /**
     * Gets the actual template data.
     *
     * <p>
     * Note that the format of this string is dictated by the {@link EncodingType} ID.
     * </p>
     */
    public String getTemplate()
    {
        return template;
    }

    /**
     * Sets the actual template data.
     *
     * <p>
     * Note that the format of this string is dictated by the {@link EncodingType} ID.
     * </p>
     *
     * @param template
     *            The new template content.
     */
    public void setTemplate(String template)
    {
        this.template = template;
    }

    /**
     * Gets the {@link LanguageType} for the template.
     *
     * <p>
     * This is an enumeration alias for {@link ContentTemplate#getLanguageId getLanguageId()}
     * </p>
     */
    public LanguageType getLanguage()
    {
        return LanguageType.languageType(languageId);
    }

    /**
     * Sets the {@link LanguageType} for the template.
     *
     * <p>
     * This is an enumeration alias for {@link ContentTemplate#setLanguageId(int) setLanguageId(int)}
     * </p>
     *
     * @param languageType
     *            The new language type for the template.
     */
    public void setLanguage(LanguageType languageType)
    {
        languageId = languageType.getValue();
    }

    /**
     * Gets the {@link ChannelType} for the template.
     *
     * <p>
     * This is an enumeration alias for {@link ContentTemplate#getChannelTypeId getChannelTypeId()}
     * </p>
     *
     * @see ChannelType
     */
    public ChannelType getChannelType()
    {
        return ChannelType.channelType(channelTypeId);
    }

    /**
     * Sets the {@link ChannelType for the template.
     *
     * <p> This is an enumeration alias for {@link ContentTemplate#setChannelTypeId(int) setChannelTypeId(int)} </p>
     *
     * @param channelType
     *            The new channel type for the template.
     *
     * @see ChannelType
     */
    public void setChannelType(ChannelType channelType)
    {
        channelTypeId = channelType.getValue();
    }

    /**
     * Gets the {@link EncodingType} for the template.
     *
     * <p>
     * This is an enumeration alias for {@link ContentTemplate#getEncodingTypeId() getEncodingTypeId()}
     * </p>
     */
    public EncodingType getEncodingType()
    {
        return EncodingType.encodingType(encodingTypeId);
    }

    /**
     * Sets the {@link EncodingType} for the template.
     *
     * <p>
     * This is an enumeration alias for {@link ContentTemplate#setEncodingTypeId(int) setEncodingTypeId(int)}
     * </p>
     *
     * @param encodingType
     *            The new encoding type for the template.
     */
    public void setEncodingType(EncodingType encodingType)
    {
        encodingTypeId = encodingType.getValue();
    }
}
