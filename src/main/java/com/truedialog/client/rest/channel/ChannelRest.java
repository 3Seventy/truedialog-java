package com.truedialog.client.rest.channel;

import com.truedialog.client.model.channel.Channel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public class ChannelRest {

    private static final String LIST = "account/{accountId}/channel/";


    public interface ChannelService {
        @GET(LIST)
        Call<List<Channel>> getList(@Path("accountId") int accountId);

    }
}