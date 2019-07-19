package com.truedialog.client.rest.account;


import com.truedialog.client.model.account.Account;
import com.truedialog.client.model.account.AccountAttribute;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class AccountRest {

    private static final String ACCOUNT = "account/{accountId}";
    private static final String ACCOUNT_LIST = "/account";
    private static final String ACCOUNT_CREATE = "/account";
    private static final String ACCOUNT_UPDATE = "account/{accountId}";
    private static final String ACCOUNT_DELETE = "account/{accountId}";


    public interface AccountService {

        @GET(ACCOUNT)
        Call<Account> getAccountById(@Path("accountId") int accountId);

        @GET(ACCOUNT_LIST)
        Call<List<Account>> getAccountList();

        @POST(ACCOUNT_CREATE)
        Call<Account> createAccount(@Body Account account);

        @PUT(ACCOUNT_UPDATE)
        Call<Account> updateAccount(@Path("accountId") int accountId, @Body Account account);

        @DELETE(ACCOUNT_DELETE)
        Call<Account> deleteAccount(@Path("accountId") int accountId);

    }

}
