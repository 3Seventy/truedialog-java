package com.truedialog.client.rest.user;

import com.truedialog.client.model.user.User;
import com.truedialog.client.model.user.UserPassword;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class UserRest {

    private static final String USER_LIST = "account/{accountId}/user";
    private static final String USER_ITEM = "account/{accountId}/user/{username}";
    private static final String CREATE_USER = "account/{accountId}/user";
    private static final String DELETE_USER = "account/{accountId}/user/{username}";
    private static final String UPDATE_USER = "account/{accountId}/user/{username}";
    private static final String LOCK_USER = "account/{accountId}/user/{username}/lock";
    private static final String UNLOCK_USER = "account/{accountId}/user/{username}/lock";
    private static final String RESET_PASSWORD = "account/{accountId}/user/{username}/password";

    public interface UserService {

        @GET(USER_ITEM)
        Call<User> getUserItem(@Path("accountId") int accountId, @Path("username") String username);

        @GET(USER_LIST)
        Call<List<User>> getUserList(@Path("accountId") int accountId);

        @POST(CREATE_USER)
        Call<User> createUser(@Path("accountId") int accountId, @Body User user);

        @DELETE(DELETE_USER)
        Call<Void> deleteUser(@Path("accountId") int accountId, @Path("username") String username);

        @PUT(UPDATE_USER)
        Call<User> updateUser(@Path("accountId") int accountId, @Path("username") String username, @Body User user);

        @PUT(LOCK_USER)
        Call<Void> lockUser(@Path("accountId") int accountId, @Path("username") String username);

        @POST(UNLOCK_USER)
        Call<Void> unlockUser(@Path("accountId") int accountId, @Path("username") String username);

        @PUT(RESET_PASSWORD)
        Call<Void> updatePassword(@Path("accountId") int accountId, @Path("username") String username, @Body UserPassword userPassword);

    }
}
