package com.truedialog.client.rest.action;

import com.truedialog.client.model.action.ActionImportContacts;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class ImportRest {

    private static final String IMPORT_LIST = "account/{accountId}/action-importContacts";
    private static final String IMPORT_ITEM = "account/{accountId}/action-importContacts/{actionId}";
    private static final String IMPORT_CREATE = "account/{accountId}/action-importContacts";
    private static final String IMPORT_DELETE = "account/{accountId}/action-importContacts/{actionId}";

    public interface ImportService {

        @GET(IMPORT_LIST)
        Call<List<ActionImportContacts>> getImportList(@Path("accountId") int accountId);

        @GET(IMPORT_ITEM)
        Call<ActionImportContacts> getImport(@Path("accountId") int accountId, @Path("actionId") int actionId);

        @POST(IMPORT_CREATE)
        Call<ActionImportContacts> createImport(@Path("accountId") int accountId, @Body ActionImportContacts importContacts);

        @DELETE(IMPORT_DELETE)
        Call<ActionImportContacts> stopImport(@Path("accountId") int accountId, @Path("actionId") int actionId);


    }
}
