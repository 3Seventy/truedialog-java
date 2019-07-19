package com.truedialog.client.rest.campaign;

import com.truedialog.client.model.campaign.Link;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class LinkRest {

    private static final String LINK_LIST = "account/{accountId}/link";
    private static final String LINK_ITEM = "account/{accountId}/link/{linkId}";
    private static final String LINK_CREATE = "account/{accountId}/link";
    private static final String LINK_UPDATE = "account/{accountId}/link/{linkId}";
    private static final String LINK_DELETE = "account/{accountId}/link/{linkId}";

    public interface LinkService {

        @GET(LINK_LIST)
        Call<List<Link>> getLinkList(@Path("accountId") int accountId);

        @GET(LINK_ITEM)
        Call<Link> getLink(@Path("accountId") int accountId, @Path("linkId") int linkId);

        @POST(LINK_CREATE)
        Call<Link> createLink(@Path("accountId") int accountId, @Body Link link);

        @PUT(LINK_UPDATE)
        Call<Link> updateLink(@Path("accountId") int accountId, @Path("linkId") int linkId, @Body Link link);

        @DELETE(LINK_DELETE)
        Call<Link> deleteLink(@Path("accountId") int accountId, @Path("linkId") int linkId);

    }

}
