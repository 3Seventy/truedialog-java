package com.truedialog.client.rest.account;

import com.truedialog.client.model.account.AccountMedia;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class AccountMediaRest {

    private static final String ACCOUNT_IMAGE_LIST = "account/{accountId}/image";
    private static final String ACCOUNT_IMAGE_ITEM = "account/{accountId}/image/{imageId}";
    private static final String ACCOUNT_IMAGE_ITEM_DELETE = "account/{accountId}/image/{imageId}";
    private static final String ACCOUNT_IMAGE_UPLOAD = "account/{accountId}/image";


    public interface AccountMediaService {

        @GET(ACCOUNT_IMAGE_ITEM)
        Call<AccountMedia> getAccountMediaById(@Path("accountId") int accountId, @Path("imageId") int imageId);

        @GET(ACCOUNT_IMAGE_LIST)
        Call<List<AccountMedia>> getAccountMediaList(@Path("accountId") int accountId);

        @DELETE(ACCOUNT_IMAGE_ITEM_DELETE)
        Call<Void> deleteAccountMedia(@Path("accountId") int accountId, @Path("imageId") int imageId);

        @Multipart
        @POST(ACCOUNT_IMAGE_UPLOAD)
        Call<List<AccountMedia>> uploadAsByteArray(@Path("accountId") int accountId,
                                             @Part MultipartBody.Part filePart);

    }
}
