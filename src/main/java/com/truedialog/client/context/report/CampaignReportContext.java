package com.truedialog.client.context.report;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.report.CampaignReportRow;
import com.truedialog.client.rest.report.CampaignReportRest;

import java.util.List;

public class CampaignReportContext extends BaseContext {

    private CampaignReportRest.CampaignReportService campaignReportService;

    public CampaignReportContext(TrueDialogClient trueDialogClient, CampaignReportRest.CampaignReportService campaignReportService) {
        super(trueDialogClient);
        this.campaignReportService = campaignReportService;
    }

    public List<CampaignReportRow> getCampaignReport() {
        return getCampaignReport(trueDialogClient.getCurrentAccount(), 0);
    }

    public List<CampaignReportRow> getCampaignReport(boolean throwIfEmpty) {
        return getCampaignReport(trueDialogClient.getCurrentAccount(), 0, throwIfEmpty);
    }


    public List<CampaignReportRow> getCampaignReport(int subscriptionId) {
        return getCampaignReport(trueDialogClient.getCurrentAccount(), subscriptionId);
    }


    public List<CampaignReportRow> getCampaignReport(int subscriptionId, boolean throwIfEmpty) {
        return getCampaignReport(trueDialogClient.getCurrentAccount(), subscriptionId, throwIfEmpty);
    }


    public List<CampaignReportRow> getCampaignReport(int accountId, int subscriptionId) {
        return executeEntityListCall(campaignReportService.getCampaignReportList(accountId, subscriptionId));
    }


    public List<CampaignReportRow> getCampaignReport(int accountId, int subscriptionId, boolean throwIfEmpty) {
        return executeEntityListCall(campaignReportService.getCampaignReportList(accountId, subscriptionId), throwIfEmpty);
    }

    public CampaignReportRow getReportForCampaign(int campaignId) {
        return getReportForCampaign(trueDialogClient.getCurrentAccount(), campaignId);
    }

    public CampaignReportRow getReportForCampaign(int campaignId, boolean throwIfEmpty) {
        return getReportForCampaign(trueDialogClient.getCurrentAccount(), campaignId, throwIfEmpty);
    }

    public CampaignReportRow getReportForCampaign(int accountId, int campaignId) {
        return executeEntityCall(campaignReportService.getReportForCampaign(accountId, campaignId));
    }

    public CampaignReportRow getReportForCampaign(int accountId, int campaignId, boolean throwIfEmpty) {
        return executeEntityCall(campaignReportService.getReportForCampaign(accountId, campaignId), throwIfEmpty);
    }
}
