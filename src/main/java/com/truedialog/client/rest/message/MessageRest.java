package com.truedialog.client.rest.message;

import com.truedialog.client.model.action.ActionPushCampaign;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class MessageRest {

    private static final String ACTION_PUSH_CAMPAIGN = "account/{accountId}/action-pushCampaign";

    public interface MessageService {

        @POST(ACTION_PUSH_CAMPAIGN)
        Call<ActionPushCampaign> submit(@Path("accountId") int accountId, @Body ActionPushCampaign action);

    }

}
