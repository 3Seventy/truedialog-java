package com.truedialog.client.rest.callback;

import com.truedialog.client.model.callback.Callback;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class CallbackRest {


    private static final String CALLBACK_LIST = "account/{accountId}/callback";
    private static final String CALLBACK_ITEM = "account/{accountId}/callback/{callbackId}";
    private static final String CALLBACK_CREATE = "account/{accountId}/callback";
    private static final String CALLBACK_UPDATE = "account/{accountId}/callback/{callbackId}";
    private static final String CALLBACK_DELETE = "account/{accountId}/callback/{callbackId}";

    public interface CallbackService {

        @GET(CALLBACK_LIST)
        Call<List<Callback>> getCallbackList(@Path("accountId") int accountId);

        @GET(CALLBACK_ITEM)
        Call<Callback> getCallback(@Path("accountId") int accountId, @Path("callbackId") int callbackId);

        @POST(CALLBACK_CREATE)
        Call<Callback> createCallback(@Path("accountId") int accountId, @Body Callback callback);

        @PUT(CALLBACK_UPDATE)
        Call<Callback> updateCallback(@Path("accountId") int accountId, @Path("callbackId") int callbackId, @Body Callback callback);

        @DELETE(CALLBACK_DELETE)
        Call<Void> deleteCallback(@Path("accountId") int accountId, @Path("callbackId") int callbackId);

    }
}
