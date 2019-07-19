package com.truedialog.client.context.campaign;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.campaign.CampaignQuestion;
import com.truedialog.client.rest.campaign.CampaignQuestionRest;

public class CampaignQuestionContext extends BaseContext {

    private CampaignQuestionRest.CampaignQuestionService campaignQuestionService;

    public CampaignQuestionContext(TrueDialogClient trueDialogClient, CampaignQuestionRest.CampaignQuestionService campaignQuestionService) {
        super(trueDialogClient);
        this.campaignQuestionService = campaignQuestionService;
    }

    public CampaignQuestion getById(int campaignId) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId);
    }

    public CampaignQuestion getById(int campaignId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId, throwIfEmpty);
    }

    public CampaignQuestion getById(int accountId, int campaignId) {
        return executeEntityCall(campaignQuestionService.getCampaignQuestion(accountId, campaignId));
    }

    public CampaignQuestion getById(int accountId, int campaignId, boolean throwIfEmpty) {
        return executeEntityCall(campaignQuestionService.getCampaignQuestion(accountId, campaignId), throwIfEmpty);
    }

    public CampaignQuestion create(int accountId, int campaignId, CampaignQuestion question) {
        return executeEntityCall(campaignQuestionService.createCampaignQuestion(accountId, campaignId, question), true);
    }

    public CampaignQuestion create(int campaignId, CampaignQuestion question) {
        return create(trueDialogClient.getCurrentAccount(), campaignId, question);
    }

    public CampaignQuestion update(int accountId, int campaignId, CampaignQuestion question) {
        return executeEntityCall(campaignQuestionService.updateCampaignQuestion(accountId, campaignId, question), true);

    }

    public CampaignQuestion update(int campaignId, CampaignQuestion question) {
        return update(trueDialogClient.getCurrentAccount(), campaignId, question);
    }

}
