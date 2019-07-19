package com.truedialog.client.rest.campaign;

import com.truedialog.client.model.campaign.CampaignSurvey;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class CampaignSurveyRest {

    private static final String CAMPAIGN_SURVEY_ITEM = "account/{accountId}/campaign/{campaignId}/dialog";
    private static final String CAMPAIGN_SURVEY_CREATE = "account/{accountId}/campaign/{campaignId}/dialog";
    private static final String CAMPAIGN_SURVEY_UPDATE = "account/{accountId}/campaign/{campaignId}/dialog";


    public interface CampaignSurveyService {

        @GET(CAMPAIGN_SURVEY_ITEM)
        Call<CampaignSurvey> getCampaignSurvey(@Path("accountId") int accountId, @Path("campaignId") int campaignId);

        @POST(CAMPAIGN_SURVEY_CREATE)
        Call<CampaignSurvey> createCampaignSurvey(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Body CampaignSurvey survey);

        @POST(CAMPAIGN_SURVEY_UPDATE)
        Call<CampaignSurvey> updateCampaignSurvey(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Body CampaignSurvey survey);
    }
}
