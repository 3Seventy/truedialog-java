package com.truedialog.client.model.contact;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.CampaignType;
import com.truedialog.client.model.base.Base;

/**
 * User defined attribute data.
 * <p>
 * Contact attributes provide a way to save data to contacts via the API or a
 * // * {@link CampaignType#DIALOG DIALOG} campaign.
 * </p>
 * <p>
 * Attributes must be defined before they can be used. The SDK does not currently support defining these attributes
 * directly. However you can do so using either the Vector Portal or making direct API calls. This only needs to be done
 * once per attribute definition.
 * </p>
 * <p>
 * The name of the attribute must be unique, and must follow standard programming naming conventions (must start with an
 * underscore or letter, followed by letters, numbers, and underscores).
 * </p>
 * <p>
 * Child accounts inherit those attributes defined by their parent.
 * </p>
 *
 * @author Bryce Simonds
 * @see Contact
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ContactAttribute extends Base {
    @JsonProperty("name")
    private String name;

    @JsonProperty("Value")
    private String value;
    /**
     * The account which the contact is owned by
     */
    @JsonProperty("AccountId")
    public int accountId;
    /**
     * The contact to which the property belongs.
     */
    @JsonProperty
    public int contactId;

    /**
     * Gets the attribute definition name that is set.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the attribute definition to use.
     *
     * @param name The attribute definition name to use.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value set for this contact on this attribute definition name.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value for this contact on this attribute definition name..
     *
     * @param value The new value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

}