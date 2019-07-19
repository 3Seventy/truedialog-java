package com.truedialog.client.rest.campaign;

import com.truedialog.client.model.campaign.Campaign;
import com.truedialog.client.model.internal.CreateCampaign;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class CampaignRest {


    private static final String CAMPAIGN_LIST = "account/{accountId}/campaign?onlyMine={onlyMine}";
    private static final String CAMPAIGN_ITEM = "account/{accountId}/campaign/{campaignId}";
    private static final String CAMPAIGN_CREATE = "account/{accountId}/campaign";
    private static final String CAMPAIGN_UPDATE = "account/{accountId}/campaign/{campaignId}";
    private static final String CAMPAIGN_DELETE = "account/{accountId}/campaign/{campaignId}";
    private static final String CAMPAIGN_INTERNAL_CREATE = "account/{accountId}/campaign";

    public interface CampaignService {


        @GET(CAMPAIGN_LIST)
        Call<List<Campaign>> getCampaignList(@Path("accountId") int accountId, @Path("onlyMine") boolean onlyMine);

        @GET(CAMPAIGN_ITEM)
        Call<Campaign> getCampaign(@Path("accountId") int accountId, @Path("campaignId") int campaignId);

        @POST(CAMPAIGN_CREATE)
        Call<Campaign> createCampaign(@Path("accountId") int accountId, @Body Campaign campaign);

        @PUT(CAMPAIGN_UPDATE)
        Call<Campaign> updateCampaign(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Body Campaign campaign);

        @DELETE(CAMPAIGN_DELETE)
        Call<Campaign> deleteCampaign(@Path("accountId") int accountId, @Path("campaignId") int campaignId);


        @POST(CAMPAIGN_INTERNAL_CREATE)
        Call<Campaign> createInternalCampaign(@Path("accountId") int accountId, @Body CreateCampaign createCampaign);

    }

}
