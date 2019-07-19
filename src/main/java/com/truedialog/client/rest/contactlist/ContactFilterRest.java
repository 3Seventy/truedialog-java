package com.truedialog.client.rest.contactlist;

import com.truedialog.client.model.filter.ContactFilter;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public class ContactFilterRest {
    private static final String CONTACT_FILTER_LIST = "/account/{accountId}/contactlist/{contactListId}/group/{groupId}/filter";
    private static final String CONTACT_FILTER_ITEM = "/account/{accountId}/contactlist/{contactListId}/group/{groupId}/filter/{filterId}";
    private static final String CONTACT_FILTER_ITEM_UPDATE = "/account/{accountId}/contactlist/{contactListId}/group/{groupId}/filter/{filterId}";


    public interface ContactFilterService {

        @GET(CONTACT_FILTER_LIST)
        Call<List<ContactFilter>> getContactFilterList(@Path("accountId") int accountId, @Path("contactListId") int contactListId, @Path("groupId") int groupId);

        @GET(CONTACT_FILTER_ITEM)
        Call<ContactFilter> getContactFilterById(@Path("accountId") int accountId, @Path("contactListId") int contactListId, @Path("groupId") int groupId, @Path("filterId") int filterId);

        @POST(CONTACT_FILTER_ITEM_UPDATE)
        Call<ContactFilter> updateContactFilter (@Path("accountId") int accountId, @Path("contactListId") int contactListId, @Path("groupId") int groupId, @Body ContactFilter contactFilter);
    }
}
