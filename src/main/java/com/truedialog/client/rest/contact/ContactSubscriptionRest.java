package com.truedialog.client.rest.contact;

import com.truedialog.client.model.subscription.ContactSubscription;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public class ContactSubscriptionRest {
    private static final String CONTACT_SUBSCRIPTION_ITEM = "account/{accountId}/contact/{contactId}/subscription/{subscriptionId}";
    private static final String CONTACT_SUBSCRIPTION_LIST = "account/{accountId}/contact/{contactId}/subscription";

    public interface ContactSubscriptionService{
        @GET(CONTACT_SUBSCRIPTION_ITEM)
        Call<ContactSubscription> getContactSubscriptionById(@Path("accountId") int accountId, @Path("contactId") int contactId, @Path("subscriptionId") int subscriptionId);

        @GET(CONTACT_SUBSCRIPTION_LIST)
        Call<List<ContactSubscription>> getContactSubscriptionList(@Path("accountId") int accountId, @Path("contactId") int contactId);

    }

}
