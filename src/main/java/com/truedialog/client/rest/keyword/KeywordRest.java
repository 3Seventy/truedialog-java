package com.truedialog.client.rest.keyword;


import com.truedialog.client.model.campaign.Campaign;
import com.truedialog.client.model.contact.Contact;
import com.truedialog.client.model.keyword.Keyword;
import retrofit2.Call;
import retrofit2.http.*;

import javax.annotation.PostConstruct;
import java.util.List;

public class KeywordRest {
    private static final String ALL_LIST = "account/{accountId}/keyword";
    private static final String LIST = "account/{accountId}/channel/{channel}/keyword";
    private static final String ITEM = "account/{accountId}/channel/{channel}/keyword/{keyword}";
    private static final String KEYWORD_CONTACT = "/account/{accountId}/keyword/{keywordId}/contact";
    private static final String KEYWORD_CAMPAIGN = "/account/{accountId}/channel/{channel}/keyword/{keyword}/campaign";

    public interface KeywordService {
        @GET(ALL_LIST)
        Call<List<Keyword>> getTotalList(@Path("accountId") int accountId);

        @GET(LIST)
        Call<List<Keyword>> getList(@Path("accountId") int accountId, @Path("channel") String channel);

        @GET(ITEM)
        Call<Keyword> getKeywordByName(@Path("accountId") int accountId, @Path("channel") String channel, @Path("keyword") String keyword);

        @POST(LIST)
        Call<Keyword> create(@Path("accountId") int accountId, @Path("channel") String channel, @Body Keyword keyword);

        @DELETE(ITEM)
        Call<Void> delete(@Path("accountId") int accountId, @Path("channel") String channel, @Path("keyword") String keyword);

        @GET(KEYWORD_CONTACT)
        Call<List<Contact>> getKeywordContacts(@Path("accountId") int accountId, @Path("keywordId") int keywordId);

        @GET(KEYWORD_CAMPAIGN)
        Call<Campaign> getAttachedCampaign(@Path("accountId") int accountId, @Path("channel") String channel, @Path("keyword") String keyword);

        @POST(KEYWORD_CAMPAIGN)
        Call<Keyword> attachCampaign(@Path("accountId") int accountId, @Path("channel") String channel, @Path("keyword") String keyword, @Body int campaignId );

        @DELETE(KEYWORD_CAMPAIGN)
        Call<Void> detachCampaign(@Path("accountId") int accountId, @Path("channel") String channel, @Path("keyword") String keyword);
    }
}
