package com.truedialog.client.model.campaign;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.QuestionType;
import com.truedialog.client.model.base.Base;

import java.util.ArrayList;


public class CampaignQuestion extends Base {

    /**
     * The account which owns the campaign.
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The survey this question belongs to.
     */
    @JsonProperty("SurveyId")
    private int surveyId;

    /**
     * The question's response type.
     */
    @JsonProperty("QuestionTypeId")
    private int questionTypeId;
    /**
     * Enumeration mapping for QuestionTypeId
     */
    @JsonIgnore
    private QuestionType questionType;

    /**
     * The contact attribute that answers should be stored in.
     */
    @JsonProperty("ContactAttributeDefinitionId")
    private int contactAttributeDefinitionId;


    /**
     * A list of answers for this question. (OPTIONAL)
     */
    @JsonProperty("Answers")
    private Iterable<CampaignAnswer> answers = new ArrayList<>();

    /**
     * The label for the question in the UI
     */
    @JsonProperty("Label")
    private String label;

    /**
     * The description of the question.
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

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public QuestionType getQuestionType() {
        return QuestionType.questionType(questionTypeId);
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionTypeId = questionType.getValue();
    }

    public int getContactAttributeDefinitionId() {
        return contactAttributeDefinitionId;
    }

    public void setContactAttributeDefinitionId(int contactAttributeDefinitionId) {
        this.contactAttributeDefinitionId = contactAttributeDefinitionId;
    }

    public Iterable<CampaignAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Iterable<CampaignAnswer> answers) {
        this.answers = (answers == null) ? new ArrayList<CampaignAnswer>() : answers;
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

