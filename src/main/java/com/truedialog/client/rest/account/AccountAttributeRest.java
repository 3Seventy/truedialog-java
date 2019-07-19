package com.truedialog.client.rest.account;

import com.truedialog.client.model.account.AccountAttribute;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class AccountAttributeRest {

    private static final String ACCOUNT_ATTRIBUTE = "account/{accountId}/attribute/{nameOrId}";
    private static final String ACCOUNT_ATTRIBUTE_LIST = "account/{accountId}/attribute";
    private static final String ACCOUNT_ATTRIBUTE_CREATE = "account/{accountId}/attribute/{nameOrId}";
    private static final String ACCOUNT_ATTRIBUTE_UPDATE = "account/{accountId}/attribute/{nameOrId}";
    private static final String ACCOUNT_ATTRIBUTE_DELETE = "account/{accountId}/attribute/{nameOrId}";


    public interface AccountAttributeService {

        @GET(ACCOUNT_ATTRIBUTE)
        Call<String> getAccountAttributeByName(@Path("accountId") int accountId, @Path("nameOrId") String name);

        @GET(ACCOUNT_ATTRIBUTE)
        Call<String> getAccountAttributeById(@Path("accountId") int accountId, @Path("nameOrId") int id);

        @GET(ACCOUNT_ATTRIBUTE_LIST)
        Call<List<AccountAttribute>> getAttributeList(@Path("accountId") int accountId);

        @POST(ACCOUNT_ATTRIBUTE_CREATE)
        Call<AccountAttribute> createAttribute(@Path("accountId") int accountId, @Path("nameOrId") String name, @Body Object accountAttribute);

        @PUT(ACCOUNT_ATTRIBUTE_UPDATE)
        Call<AccountAttribute> updateAttribute(@Path("accountId") int accountId, @Path("nameOrId") int id, @Body Object accountAttribute);

        @DELETE(ACCOUNT_ATTRIBUTE_DELETE)
        Call<AccountAttribute> deleteAttribute(@Path("accountId") int accountId, @Path("nameOrId") int id);

        @DELETE(ACCOUNT_ATTRIBUTE_DELETE)
        Call<AccountAttribute> deleteAttribute(@Path("accountId") int accountId, @Path("nameOrId") String id);

    }
}
