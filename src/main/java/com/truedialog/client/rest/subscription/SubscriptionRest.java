package com.truedialog.client.rest.subscription;

import com.truedialog.client.model.subscription.Subscription;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public class SubscriptionRest {
    private static final String LIST = "account/{accountId}/subscription";
    private static final String ITEM = "account/{accountId}/subscription/{subscriptionId}";

    public interface SubscriptionService {

        @GET(LIST)
        Call<List<Subscription>> getSubscriptionList(@Path("accountId") int accountId);

        @GET(ITEM)
        Call<Subscription> getSubscriptionById(@Path("accountId") int accountId, @Path("subscriptionId") int subscriptionId);

    }


}
