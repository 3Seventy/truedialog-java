package com.truedialog.client.rest.account;

import com.truedialog.client.model.account.AccountAttributeDefinition;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class AccountAttributeDefinitionRest {

    private static final String ACCOUNT_ATTRIBUTE_DEFINITION_ITEM = "account/{accountId}/attributeDef/{definitionId}";
    private static final String ACCOUNT_ATTRIBUTE_DEFINITION_LIST = "account/{accountId}/attributeDef";
    private static final String ACCOUNT_ATTRIBUTE_DEFINITION_ADD = "account/{accountId}/attributeDef";
    private static final String ACCOUNT_ATTRIBUTE_DEFINITION_DELETE = "account/{accountId}/attributeDef/{definitionId}";

    public interface AccountAttributeDefinitionService {

        @GET(ACCOUNT_ATTRIBUTE_DEFINITION_ITEM)
        Call<AccountAttributeDefinition> getAccountAttributeDefinition(@Path("accountId") int accountId, @Path("definitionId") int definitionId);

        @GET(ACCOUNT_ATTRIBUTE_DEFINITION_LIST)
        Call<List<AccountAttributeDefinition>> getAccountAttributeDefinitionList(@Path("accountId") int accountId);

        @POST(ACCOUNT_ATTRIBUTE_DEFINITION_ADD)
        Call<AccountAttributeDefinition> addAccountAttributeDefinition(@Path("accountId") int accountId, @Body AccountAttributeDefinition accountAttributeDefinition);

        @DELETE(ACCOUNT_ATTRIBUTE_DEFINITION_DELETE)
        Call<Void> deleteAccountAttributeDefinition(@Path("accountId") int accountId, @Path("definitionId") int definitionId);
    }

}
