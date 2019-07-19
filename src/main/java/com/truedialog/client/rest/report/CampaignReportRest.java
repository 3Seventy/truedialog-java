package com.truedialog.client.rest.report;

import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.report.CampaignReportRow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public class CampaignReportRest {

    private static final String CAMPAIGN_REPORT_LIST = "account/{accountId}/newReport/campaignDetailed/{subscriptionId}";
    private static final String CAMPAIGN_REPORT_ITEM = "account/{accountId}/newReport/campaignDetailed/{subscriptionId}/{campaignId}";


    public interface CampaignReportService {

        @GET(CAMPAIGN_REPORT_LIST)
        Call<List<CampaignReportRow>> getCampaignReportList(@Path("accountId") int accountId, @Path("subscriptionId") int subscriptionId);

        @GET(CAMPAIGN_REPORT_ITEM)
        Call<CampaignReportRow> getReportForCampaign(@Path("accountId") int accountId, @Path("campaignId") int campaignId);

    }
}
