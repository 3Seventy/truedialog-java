package com.truedialog.client.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.ChannelType;
import com.truedialog.client.enums.EncodingType;
import com.truedialog.client.enums.LanguageType;

/**
 * Details for creating or updating a template
 */
public class CreateUpdateContentTemplate {
    /**
     * The language this template is for.
     */
    @JsonProperty("LanguageId")
    private int languageId;

    /**
     * The type of channel this content can be sent to.
     */
    @JsonProperty("ChannelTypeId")
    private int channelTypeId;

    /**
     * The format of the tempalte data
     *
     * <p>
     * Dictates if this is a plain text or razor template
     * </p>
     */
    @JsonProperty("EncodingTypeId")
    private int encodingTypeId;

    /**
     * The actual template
     */
    @JsonProperty("Template")
    private String template;

    /**
     * Email subject if any
     */
    @JsonProperty("Subject")
    private String subject;

    /**
     * Email from address if any
     */
    @JsonProperty("From")
    private String from;

    /**
     * ID of media to send
     */
    @JsonProperty("MediaId")
    private int mediaId;

    /**
     * Enumeration wrapper for LanguageTypeId
     */
    public LanguageType getLanguageType() {
        return LanguageType.languageType(languageId);
    }

    public void setLanguageType(LanguageType languageType) {
        languageId = languageType.getValue();
    }

    /**
     * Enumeration wrapper for ChannelTypeId
     */

    public ChannelType getChannelType() {
        return ChannelType.channelType(channelTypeId);
    }

    public void setChannelType(ChannelType channelType) {
        channelTypeId = channelType.getValue();
    }

    /**
     * Enumeration wrapper for EncodingTypeId
     */

    public EncodingType getEncodingType() {
        return EncodingType.encodingType(encodingTypeId);
    }

    public void setEncodingType(EncodingType encodingType) {
        encodingTypeId = encodingType.getValue();
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}