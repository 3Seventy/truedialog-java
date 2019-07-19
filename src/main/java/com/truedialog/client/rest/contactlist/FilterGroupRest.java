package com.truedialog.client.rest.contactlist;

import com.truedialog.client.model.filter.FilterGroup;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public class FilterGroupRest {

    private static final String LIST = "/account/{accountId}/contactlist/{contactListId}/group";
    private static final String ITEM = "/account/{accountId}/contactlist/{contactListId}/group/{groupId}";


    public interface FilterGroupService {

        @GET(ITEM)
        Call<FilterGroup> getFilterGroupById(@Path("accountId") int accountId, @Path("contactListId") int contactListId, @Path("groupId") int groupId);

        @GET(LIST)
        Call<List<FilterGroup>> getFilterGroupList(@Path("accountId") int accountId, @Path("contactListId") int contactListId);

    }
}
