package com.truedialog.client.model.content;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.ChannelType;
import com.truedialog.client.enums.LanguageType;
import com.truedialog.client.model.account.Account;
import com.truedialog.client.model.base.BaseAudited;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides a container for templates.
 *
 * <p>
 * Content objects group related {@link ContentTemplate templates}. This is done to allow for a campaign to hold
 * different templates for different types of messages. (i.e.: SMS vs. MMS vs. Email) They can also hold the same
 * message translated into different languages. This allows for a single campaign push to support multiple different
 * languages, and target types with minimal fuss.
 * </p>
 *
 * <p>
 * <strong>IMPORTANT NOTE:</strong> There is no requirement to have more than one template under a content object.
 * However you must have at least one template and it must be part of a content group.
 * </p>
 *
 * <p>
 * Additionally, you may only have one template per type per language. For example, you may have a template for
 * {@link ChannelType#SMS SMS}/{@link LanguageType#ENGLISH ENGLISH} and another template for {@link ChannelType#SMS SMS}/{@link LanguageType#FRENCH FRENCH}, but not two templates with {@link ChannelType#SMS SMS}/
 * {@link LanguageType#ENGLISH ENGLISH}.
 * </p>
 *
 * @see ChannelType
 * @see LanguageType
 *
 * @author Bryce Simonds
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class Content extends BaseAudited
{
    @JsonProperty("AccountId")
    private Integer accountId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonIgnore
    @JsonProperty("Templates")
    private List<ContentTemplate> templates = new ArrayList<ContentTemplate>();

    /**
     * Gets the {@link Account} ID which owns this content object.
     */
    public Integer getAccountId()
    {
        return accountId;
    }

    /**
     * Sets the {@link Account} ID which owns this content object.
     *
     * @param accountId
     *            The new account ID to use for this object.
     */
    public void setAccountId(Integer accountId)
    {
        this.accountId = accountId;
    }

    /**
     * Gets the name of this content object.
     * <p>
     * This is a free form name you can use to provide a human readable identifier to each object
     * </p>
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this content object.
     *
     * @param name
     *            The new name for the content object.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the free form description field.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets the free form description fields.
     * <p>
     * The free form description field allows you to set a human readable detailed description of the object.
     * </p>
     *
     * @param description
     *            The new description of the object.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Gets a list of templates that are under this content object.
     */
    public List<ContentTemplate> getTemplates()
    {
        return templates;
    }

    /**
     * Sets the list of templates.
     *
     * <p>
     * If the list is set to {@code null} or is an empty list then no adjustments to existing content objects will be
     * made. However you can adjust templates and save them in one call here.
     * </p>
     *
     * @param templates
     *            The list of templates that should be added or updated.
     */
    public void setTemplates(List<ContentTemplate> templates)
    {
        this.templates = (templates == null) ? new ArrayList<ContentTemplate>() : templates;
    }

}