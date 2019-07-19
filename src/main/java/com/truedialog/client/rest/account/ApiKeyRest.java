package com.truedialog.client.rest.account;

import com.truedialog.client.model.account.ApiKey;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class ApiKeyRest {

    private static final String API_KEY_LIST = "account/{accountId}/api-key";
    private static final String API_KEY_ITEM = "account/{accountId}/api-key/{keyId}";
    private static final String API_KEY_CREATE = "account/{accountId}/api-key";
    private static final String API_KEY_UPDATE = "account/{accountId}/api-key/{keyId}";
    private static final String API_KEY_REVOKE = "account/{accountId}/api-key/{keyId}";

    public interface ApiKeyService {

        @GET(API_KEY_LIST)
        Call<List<ApiKey>> getApiKeyList(@Path("accountId") int accountId);

        @GET(API_KEY_ITEM)
        Call<ApiKey> getApiKey(@Path("accountId") int accountId, @Path("keyId") int keyId);

        @POST(API_KEY_CREATE)
        Call<ApiKey> createApiKey(@Path("accountId") int accountId, @Body ApiKey apiKey);

        @PUT(API_KEY_UPDATE)
        Call<ApiKey> updateSecret(@Path("accountId") int accountId, @Path("keyId") int keyId);

        @DELETE(API_KEY_REVOKE)
        Call<Void> revoke(@Path("accountId") int accountId, @Path("keyId") int keyId);

    }

}
