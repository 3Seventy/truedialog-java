package com.truedialog.client.model.campaign;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.LinkType;
import com.truedialog.client.model.base.BaseAudited;

/**
 * Describes a link that can be sent in a razor template.
 * <p>
 * Links are shortened when we send them. This is to save characters when readling
 * with SMS messages.
 * </p>
 */

public class Link extends BaseAudited {
    /**
     * The account ID which owns the link
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The campaign this link is part of.
     */
    @JsonProperty("CampaignId")
    private int campaignId;

    /**
     * The contact attribute ID to append to the URL if desired.
     */
    @JsonProperty("ContactAttributeDefinitionId")
    private int contactAttributeDefinitionId;

    /**
     * Enumeration mapping to LinkTypeId
     */
    private LinkType getLinkType() {
        return LinkType.linkType(linkTypeId);
    }

    private void setLinkType(LinkType linkType) {
        this.linkTypeId = linkType.getValue();
    }


    /**
     * The type of link this is. Either Static or Dynamic
     */
    @JsonProperty("LinkTypeId")
    private int linkTypeId;

    /**
     * The name of the link.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * The URL we should redirect to.
     */
    @JsonProperty("RedirectURL")
    private String redirectURL;

    /**
     * Set if we should request the user's location before redirecting.
     */
    @JsonProperty("RequestLocation")
    private boolean requestLocation;

    /**
     * The short URL to use.
     */
    @JsonProperty("ShortBaseURL")
    private String shortBaseURL;

    /**
     * The contact attribute ID to be updated.
     */
    @JsonProperty("UpdateContactAttributeDefinitionId")
    private int updateContactAttributeDefinitionId;

    /**
     * The value to update the contact attribute to.
     */
    @JsonProperty("UpdateContactAttributeValue")
    private String updateContactAttributeValue;

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

    public int getContactAttributeDefinitionId() {
        return contactAttributeDefinitionId;
    }

    public void setContactAttributeDefinitionId(int contactAttributeDefinitionId) {
        this.contactAttributeDefinitionId = contactAttributeDefinitionId;
    }

    public int getLinkTypeId() {
        return linkTypeId;
    }

    public void setLinkTypeId(int linkTypeId) {
        this.linkTypeId = linkTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public boolean isRequestLocation() {
        return requestLocation;
    }

    public void setRequestLocation(boolean requestLocation) {
        this.requestLocation = requestLocation;
    }

    public String getShortBaseURL() {
        return shortBaseURL;
    }

    public void setShortBaseURL(String shortBaseURL) {
        this.shortBaseURL = shortBaseURL;
    }

    public int getUpdateContactAttributeDefinitionId() {
        return updateContactAttributeDefinitionId;
    }

    public void setUpdateContactAttributeDefinitionId(int updateContactAttributeDefinitionId) {
        this.updateContactAttributeDefinitionId = updateContactAttributeDefinitionId;
    }

    public String getUpdateContactAttributeValue() {
        return updateContactAttributeValue;
    }

    public void setUpdateContactAttributeValue(String updateContactAttributeValue) {
        this.updateContactAttributeValue = updateContactAttributeValue;
    }
}