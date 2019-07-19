package com.truedialog.client.context.campaign;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.campaign.CampaignAnswer;
import com.truedialog.client.rest.campaign.CampaignAnswerRest;

import java.util.List;

public class CampaignAnswerContext extends BaseContext {

    private CampaignAnswerRest.CampaignAnswerService campaignAnswerService;

    public CampaignAnswerContext(TrueDialogClient trueDialogClient, CampaignAnswerRest.CampaignAnswerService campaignAnswerService) {
        super(trueDialogClient);
        this.campaignAnswerService = campaignAnswerService;
    }

    // Get list

    public List<CampaignAnswer> getList(int campaignId) {
        return getList(trueDialogClient.getCurrentAccount(), campaignId);
    }

    public List<CampaignAnswer> getList(int campaignId, boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), campaignId, throwIfEmpty);
    }

    public List<CampaignAnswer> getList(int accountId, int campaignId) {
        return executeEntityListCall(campaignAnswerService.getCampaignAnswerList(accountId, campaignId));
    }

    public List<CampaignAnswer> getList(int accountId, int campaignId, boolean throwIfEmpty) {
        return executeEntityListCall(campaignAnswerService.getCampaignAnswerList(accountId, campaignId), throwIfEmpty);
    }

    // By id

    public CampaignAnswer getById(int campaignId, int answerId) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId, answerId);
    }

    public CampaignAnswer getById(int campaignId, int answerId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId, answerId, throwIfEmpty);
    }

    public CampaignAnswer getById(int accountId, int campaignId, int answerId) {
        return executeEntityCall(campaignAnswerService.getCampaignAnswer(accountId, campaignId, answerId));
    }

    public CampaignAnswer getById(int accountId, int campaignId, int answerId, boolean throwIfEmpty) {
        return executeEntityCall(campaignAnswerService.getCampaignAnswer(accountId, campaignId, answerId), throwIfEmpty);
    }


    public CampaignAnswer create(int accountId, int campaignId, CampaignAnswer answer) {
        return executeEntityCall(campaignAnswerService.createCampaignAnswer(accountId, campaignId, answer), true);
    }

    public CampaignAnswer create(int campaignId, CampaignAnswer answer) {
        int accountId = answer.getAccountId() > 0 ? answer.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, campaignId, answer);
    }

    public CampaignAnswer create(CampaignAnswer answer) {
        if (answer.getCampaignId() == 0)
            throw new IllegalArgumentException("Campaign ID is missing.");

        int accountId = answer.getAccountId() > 0 ? answer.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, answer.getCampaignId(), answer);
    }

    public CampaignAnswer update(int accountId, int campaignId, int answerId, CampaignAnswer answer) {
        return executeEntityCall(campaignAnswerService.updateCampaignAnswer(accountId, campaignId, answerId, answer), true);
    }

    public CampaignAnswer update(int campaignId, int answerId, CampaignAnswer answer) {
        int accountId = answer.getAccountId() > 0 ? answer.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, campaignId, answerId, answer);
    }

    public CampaignAnswer update(CampaignAnswer answer) {
        if (answer.getCampaignId() == 0)
            throw new IllegalArgumentException("Campaign ID is missing.");

        if (answer.getId() == 0)
            throw new IllegalArgumentException("Answer ID is missing.");

        int accountId = answer.getAccountId() > 0 ? answer.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, answer.getCampaignId(), answer.getId(), answer);
    }

    public void delete(int accountId, int campaignId, int answerId) {
        executeEntityCall(campaignAnswerService.deleteCampaignAnswer(accountId, campaignId, answerId), true);
    }

    public void delete(int campaignId, int answerId) {
        delete(trueDialogClient.getCurrentAccount(), campaignId, answerId);
    }

    public void delete(CampaignAnswer answer) {
        if (answer.getCampaignId() == 0)
            throw new IllegalArgumentException("Campaign ID is missing.");

        if (answer.getId() == 0)
            throw new IllegalArgumentException("Answer ID is missing.");

        int accountId = answer.getAccountId() > 0 ? answer.getAccountId() : trueDialogClient.getCurrentAccount();
        delete(accountId, answer.getCampaignId(), answer.getId());
    }
}
