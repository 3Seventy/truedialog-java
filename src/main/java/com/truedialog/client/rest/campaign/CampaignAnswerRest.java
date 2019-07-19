package com.truedialog.client.rest.campaign;

import com.truedialog.client.model.campaign.CampaignAnswer;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class CampaignAnswerRest {

    private static final String CAMPAIGN_ANSWER_LIST = "account/{accountId}/campaign/{campaignId}/question/answer";
    private static final String CAMPAIGN_ANSWER_ITEM = "account/{accountId}/campaign/{campaignId}/question/answer/{answerId}";
    private static final String CAMPAIGN_ANSWER_CREATE = "account/{accountId}/campaign/{campaignId}/question/answer";
    private static final String CAMPAIGN_ANSWER_UPDATE = "account/{accountId}/campaign/{campaignId}/question/answer/{answerId}";
    private static final String CAMPAIGN_ANSWER_DELETE = "account/{accountId}/campaign/{campaignId}/question/answer/{answerId}";


    public interface CampaignAnswerService {

        @GET(CAMPAIGN_ANSWER_LIST)
        Call<List<CampaignAnswer>> getCampaignAnswerList(@Path("accountId") int accountId, @Path("campaignId") int campaignId);

        @GET(CAMPAIGN_ANSWER_ITEM)
        Call<CampaignAnswer> getCampaignAnswer(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Path("answerId") int answerId);

        @POST(CAMPAIGN_ANSWER_CREATE)
        Call<CampaignAnswer> createCampaignAnswer(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Body CampaignAnswer answer);

        @PUT(CAMPAIGN_ANSWER_UPDATE)
        Call<CampaignAnswer> updateCampaignAnswer(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Path("answerId") int answerId, @Body CampaignAnswer answer);

        @DELETE(CAMPAIGN_ANSWER_DELETE)
        Call<Void> deleteCampaignAnswer(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Path("answerId") int answerId);

    }
}
