package com.truedialog.client.context.campaign;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.campaign.CampaignSurvey;
import com.truedialog.client.rest.campaign.CampaignAnswerRest;
import com.truedialog.client.rest.campaign.CampaignQuestionRest;
import com.truedialog.client.rest.campaign.CampaignSurveyRest;

public class CampaignSurveyContext extends BaseContext {

    private final CampaignQuestionRest.CampaignQuestionService campaignQuestionService;
    private final CampaignAnswerRest.CampaignAnswerService campaignAnswerService;
    private final CampaignSurveyRest.CampaignSurveyService campaignSurveyService;


    public CampaignSurveyContext(TrueDialogClient trueDialogClient,
                                 CampaignSurveyRest.CampaignSurveyService campaignSurveyService,
                                 CampaignQuestionRest.CampaignQuestionService campaignQuestionService,
                                 CampaignAnswerRest.CampaignAnswerService campaignAnswerService) {
        super(trueDialogClient);
        this.campaignSurveyService = campaignSurveyService;
        this.campaignQuestionService = campaignQuestionService;
        this.campaignAnswerService = campaignAnswerService;
    }

    public CampaignQuestionContext getQuestion() {
        return new CampaignQuestionContext(trueDialogClient, this.campaignQuestionService);
    }

    public CampaignAnswerContext getAnswer() {
        return new CampaignAnswerContext(trueDialogClient, this.campaignAnswerService);
    }

    public CampaignSurvey getById(int campaignId) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId);
    }

    public CampaignSurvey getById(int campaignId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId, throwIfEmpty);
    }

    public CampaignSurvey getById(int accountId, int campaignId) {
        return executeEntityCall(campaignSurveyService.getCampaignSurvey(accountId, campaignId));
    }

    public CampaignSurvey getById(int accountId, int campaignId, boolean throwIfEmpty) {
        return executeEntityCall(campaignSurveyService.getCampaignSurvey(accountId, campaignId), throwIfEmpty);
    }

    public CampaignSurvey create(int accountId, int campaignId, CampaignSurvey survey) {
        return executeEntityCall(campaignSurveyService.createCampaignSurvey(accountId, campaignId, survey), true);
    }

    public CampaignSurvey create(int campaignId, CampaignSurvey survey) {
        return create(trueDialogClient.getCurrentAccount(), campaignId, survey);
    }

    public CampaignSurvey create(int accountId, int campaignId, int firstQuestionId) {
        CampaignSurvey campaignSurvey = new CampaignSurvey();
        campaignSurvey.setFirstQuestionId(firstQuestionId);
        return create(accountId, campaignId, campaignSurvey);
    }

    public CampaignSurvey create(int campaignId, int firstQuestionId) {
        return create(trueDialogClient.getCurrentAccount(), campaignId, firstQuestionId);
    }

    public CampaignSurvey update(int accountId, int campaignId, CampaignSurvey survey) {
        return executeEntityCall(campaignSurveyService.updateCampaignSurvey(accountId, campaignId, survey), true);
    }

    public CampaignSurvey update(int campaignId, CampaignSurvey survey) {
        return update(trueDialogClient.getCurrentAccount(), campaignId, survey);
    }

    public CampaignSurvey update(int accountId, int campaignId, int firstQuestionId) {
        CampaignSurvey campaignSurvey = new CampaignSurvey();
        campaignSurvey.setFirstQuestionId(firstQuestionId);
        return update(accountId, campaignId, campaignSurvey);
    }

    public CampaignSurvey update(int campaignId, int firstQuestionId) {
        return update(trueDialogClient.getCurrentAccount(), campaignId, firstQuestionId);
    }
}
