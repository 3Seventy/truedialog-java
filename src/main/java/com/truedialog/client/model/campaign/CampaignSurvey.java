package com.truedialog.client.model.campaign;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.BaseAudited;

/**
 * Details of survey specific campaign type.
 */
public class CampaignSurvey extends BaseAudited {
    /**
     * The account ID which owns this survey
     */
    @JsonProperty("AccountId")
    private int AccountId;

    /**
     * Pointer to the campaign which defines the first question of the survey.
     */
    @JsonProperty("FirstQuestionId")
    private int FirstQuestionId;

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        AccountId = accountId;
    }

    public int getFirstQuestionId() {
        return FirstQuestionId;
    }

    public void setFirstQuestionId(int firstQuestionId) {
        FirstQuestionId = firstQuestionId;
    }
}