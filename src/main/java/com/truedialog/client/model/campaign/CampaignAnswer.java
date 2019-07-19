package com.truedialog.client.model.campaign;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.Base;
import com.truedialog.client.model.content.Content;

/**
 * Campaign question answer definition
 */
public class CampaignAnswer extends Base {

    /**
     * Account question answer belogs to
     */
    @JsonIgnore
    private int accountId;
    /**
     * Campaign question answer belogs to
     */
    @JsonIgnore
    private int campaignId;


    /**
     * The next campaign to run in the survey.
     */
    @JsonProperty("NextCampaignId")
    private int nextCampaignId;
    /**
     * The ID of the text message content.
     */
    @JsonProperty("ContentId")
    private int contentId;
    /**
     * The content of the answer.
     */
    @JsonProperty("Content")
    private Content content;
    /**
     * A regular expression that is used to validate the user's
     * response to the answer.
     */
    @JsonProperty("Validator")
    private String validator = "";
    /**
     * A user definable ID to order the answers by on multiple choise questions.
     */
    @JsonProperty("OrderingId")
    private int orderingId;

    /**
     * The value that is actually saved when we receive this answer.
     */
    @JsonProperty("Value")
    private String value;

    /**
    * Set to start chat session when we receive this answer.
    */
        @JsonProperty("StartChat")
    public boolean startChat;

    /**
    * List of accounts (or one account) to start chat session with.
    */
        @JsonProperty("TargetAccounts")
    public String targetAccounts;

    /**
    * Set to ignore value if AssignedId already exists
    */
        @JsonProperty("OverrideAccountId")
    public boolean overrideAccountId;

    /**
    * Set to reassign AssignedId to new value
    */
        @JsonProperty("ReassignAccountId")
    public boolean reassignAccountId;

    /**
     * The lable to display in the user interface.
     */
    @JsonProperty("Label")
    private String label;
    /**
     * The description of the answer.
     * Extra field for UI stuff.
     */
    @JsonProperty("description")
    private String description;

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

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {

        this.validator = (validator == null) ? "" : validator;
    }

    public int getNextCampaignId() {
        return nextCampaignId;
    }

    public void setNextCampaignId(int nextCampaignId) {
        this.nextCampaignId = nextCampaignId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }


    public int getOrderingId() {
        return orderingId;
    }

    public void setOrderingId(int orderingId) {
        this.orderingId = orderingId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isStartChat() {
        return startChat;
    }

    public void setStartChat(boolean startChat) {
        this.startChat = startChat;
    }

    public String getTargetAccounts() {
        return targetAccounts;
    }

    public void setTargetAccounts(String targetAccounts) {
        this.targetAccounts = targetAccounts;
    }

    public boolean isOverrideAccountId() {
        return overrideAccountId;
    }

    public void setOverrideAccountId(boolean overrideAccountId) {
        this.overrideAccountId = overrideAccountId;
    }

    public boolean isReassignAccountId() {
        return reassignAccountId;
    }

    public void setReassignAccountId(boolean reassignAccountId) {
        this.reassignAccountId = reassignAccountId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
