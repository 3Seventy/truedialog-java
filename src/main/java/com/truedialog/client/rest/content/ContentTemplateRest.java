package com.truedialog.client.rest.content;

import com.truedialog.client.model.content.ContentTemplate;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class ContentTemplateRest {

    private static final String CONTENT_TEMPLATE_LIST = "account/{accountId}/content/{contentId}/template";
    private static final String CONTENT_TEMPLATE_ITEM = "account/{accountId}/content/{contentId}/template/{templateId}";
    private static final String CONTENT_TEMPLATE_CREATE = "account/{accountId}/content/{contentId}/template";
    private static final String CONTENT_TEMPLATE_UPDATE = "account/{accountId}/content/{contentId}/template/{templateId}";
    private static final String CONTENT_TEMPLATE_DELETE = "account/{accountId}/content/{contentId}/template/{templateId}";

    public interface ContentTemplateService {

        @GET(CONTENT_TEMPLATE_LIST)
        Call<List<ContentTemplate>> getContentTemplateList(@Path("accountId") int accountId, @Path("contentId") int contentId);

        @GET(CONTENT_TEMPLATE_ITEM)
        Call<ContentTemplate> getContentTemplate(@Path("accountId") int accountId, @Path("contentId") int contentId, @Path("templateId") int templateId);

        @POST(CONTENT_TEMPLATE_CREATE)
        Call<ContentTemplate> createContentTemplate(@Path("accountId") int accountId, @Path("contentId") int contentId, @Body ContentTemplate contentTemplate);

        @PUT(CONTENT_TEMPLATE_UPDATE)
        Call<ContentTemplate> updateContentTemplate(@Path("accountId") int accountId, @Path("contentId") int contentId, @Path("templateId") int templateId, @Body ContentTemplate contentTemplate);

        @DELETE(CONTENT_TEMPLATE_DELETE)
        Call<Void> deleteContentTemplate(@Path("accountId") int accountId, @Path("contentId") int contentId, @Path("templateId") int templateId);

    }

}
