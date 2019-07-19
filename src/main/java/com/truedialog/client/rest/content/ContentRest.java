package com.truedialog.client.rest.content;

import com.truedialog.client.model.content.Content;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class ContentRest {

    private static final String CONTENT_LIST = "account/{accountId}/content";
    private static final String CONTENT_ITEM = "account/{accountId}/content/{contentId}";
    private static final String CONTENT_CREATE = "account/{accountId}/content";
    private static final String CONTENT_UPDATE = "account/{accountId}/content/{contentId}";
    private static final String CONTENT_DELETE = "account/{accountId}/content/{contentId}";

    public interface ContentService {

        @GET(CONTENT_LIST)
        Call<List<Content>> getContentList(@Path("accountId") int accountId);

        @GET(CONTENT_ITEM)
        Call<Content> getContent(@Path("accountId") int accountId, @Path("contentId") int contentId);

        @POST(CONTENT_CREATE)
        Call<Content> createContent(@Path("accountId") int accountId, @Body Content content);

        @PUT(CONTENT_UPDATE)
        Call<Content> updateContent(@Path("accountId") int accountId, @Path("contentId") int contentId, @Body Content content);

        @DELETE(CONTENT_DELETE)
        Call<Void> deleteContent(@Path("accountId") int accountId, @Path("contentId") int contentId);
    }

}
