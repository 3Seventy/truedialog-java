package com.truedialog.client.model.internal;

/**
 * Details needed to create a new campaign.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.CampaignType;

public class CreateCampaign {

    /**
     * The subscription that contacts who respond to
     */
    @JsonProperty("SubscriptionId")
    private int subscriptionId;

    /**
     * The campaigns name
     */
    @JsonProperty("Name")
    private String name;

    /**
     * The type of campaign
     */
    @JsonProperty("CampaignTypeId")
    private int campaignTypeId;

    /**
     * Content that this campaign sends.
     */
    @JsonProperty("ContentId")
    private int contentId;

    /**
     * Content to add to this campaign.
     *
     * <p> This replaces ContentID, and cannot appear with ContentID</p>
     */
    @JsonProperty("Content")
    private CreateUpdateContent content;

    /**
     * Arbitrary user data field
     */
    @JsonProperty("UserData")
    private String userData;

    /**
     * This Flag is for checking Single Send Campaign.
     */

    @JsonProperty("SingleUse")
    private boolean singleUse;

    /**
     * This is set to the content Id for Single Send Campaign response.
     */
    @JsonProperty("SingleUseContentId")
    private int singleUseContentId;

    /**
     * A list of links to create along with this campaign.
     */
    @JsonProperty("Links")
    private Iterable<CreateLink> links;

    /**
     * Indicates if its a default campaign
     */
    @JsonProperty("IsDefault")
    private boolean isDefault;

    /**
     * Enumeration mapping for CampaignTypeId
     */
    public CampaignType getCampaignType() {
        return CampaignType.campaignType(campaignTypeId);
    }

    public void setCampaignType(CampaignType campaignType) {
        this.campaignTypeId = campaignType.getValue();
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCampaignTypeId() {
        return campaignTypeId;
    }

    public void setCampaignTypeId(int campaignTypeId) {
        this.campaignTypeId = campaignTypeId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public CreateUpdateContent getContent() {
        return content;
    }

    public void setContent(CreateUpdateContent content) {
        this.content = content;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public boolean isSingleUse() {
        return singleUse;
    }

    public void setSingleUse(boolean singleUse) {
        this.singleUse = singleUse;
    }

    public int getSingleUseContentId() {
        return singleUseContentId;
    }

    public void setSingleUseContentId(int singleUseContentId) {
        this.singleUseContentId = singleUseContentId;
    }

    public Iterable<CreateLink> getLinks() {
        return links;
    }

    public void setLinks(Iterable<CreateLink> links) {
        this.links = links;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}