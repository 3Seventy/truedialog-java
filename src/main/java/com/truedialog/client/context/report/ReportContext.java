package com.truedialog.client.context.report;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.rest.report.CampaignReportRest;
import com.truedialog.client.rest.report.MessageReportRest;

public class ReportContext extends BaseContext {

    private CampaignReportContext campaignReportContext;
    private MessageReportContext messageReportContext;

    public ReportContext(TrueDialogClient trueDialogClient, CampaignReportRest.CampaignReportService campaignReportService, MessageReportRest.MessageReportService messageReportService) {
        super(trueDialogClient);
        this.campaignReportContext = new CampaignReportContext(trueDialogClient, campaignReportService);
        this.messageReportContext = new MessageReportContext(trueDialogClient, messageReportService);
    }

    public CampaignReportContext getCampaignReportContext() {
        return campaignReportContext;
    }

    public MessageReportContext getMessageReportContext() {
        return messageReportContext;
    }
}
