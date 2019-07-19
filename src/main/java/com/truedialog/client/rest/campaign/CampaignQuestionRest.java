package com.truedialog.client.rest.campaign;

import com.truedialog.client.model.campaign.CampaignQuestion;
import retrofit2.Call;
import retrofit2.http.*;

public class CampaignQuestionRest {

    private static final String CAMPAIGN_QUESTION_ITEM = "account/{accountId}/campaign/{campaignId}/question";
    private static final String CAMPAIGN_QUESTION_CREATE = "account/{accountId}/campaign/{campaignId}/question";
    private static final String CAMPAIGN_QUESTION_UPDATE = "account/{accountId}/campaign/{campaignId}/question";

    public interface CampaignQuestionService {

        @GET(CAMPAIGN_QUESTION_ITEM)
        Call<CampaignQuestion> getCampaignQuestion(@Path("accountId") int accountId, @Path("campaignId") int campaignId);

        @POST(CAMPAIGN_QUESTION_CREATE)
        Call<CampaignQuestion> createCampaignQuestion(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Body CampaignQuestion question);

        @PUT(CAMPAIGN_QUESTION_UPDATE)
        Call<CampaignQuestion> updateCampaignQuestion(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Body CampaignQuestion question);
    }

}
