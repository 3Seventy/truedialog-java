package com.truedialog.client.model.internal;

/**
 * Used for creating or updating a link
 */
class CreateLink {
    /**
     * The campaign ID that the link is attached to.
     */
    private int campaignId;

    /**
     * The type of link this is.
     */
    private int linkTypeId;

    /**
     * Set if we should collect user's location when they click the link
     */
    private boolean requestLocation;

    /**
     * The name of this link which is used when creating razor templates.
     */
    private String name;

    /**
     * The URL we should redirect to.
     */
    private String redirectURL;

    /**
     * A contact attribute ID or name to append as a URL query String.
     */
    private String contactAttributeDefinitionId;

    /**
     * The Contact Attribute ID to be updated
     */
    private int updateContactAttributeDefinitionId;

    /**
     * Contact Attribute value to update
     */
    private String updateContactAttributeValue;

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getLinkTypeId() {
        return linkTypeId;
    }

    public void setLinkTypeId(int linkTypeId) {
        this.linkTypeId = linkTypeId;
    }

    public boolean isRequestLocation() {
        return requestLocation;
    }

    public void setRequestLocation(boolean requestLocation) {
        this.requestLocation = requestLocation;
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

    public String getContactAttributeDefinitionId() {
        return contactAttributeDefinitionId;
    }

    public void setContactAttributeDefinitionId(String contactAttributeDefinitionId) {
        this.contactAttributeDefinitionId = contactAttributeDefinitionId;
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