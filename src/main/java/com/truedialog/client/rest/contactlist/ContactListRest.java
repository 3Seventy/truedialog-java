package com.truedialog.client.rest.contactlist;

import com.truedialog.client.model.contact.Contact;
import com.truedialog.client.model.filter.ContactList;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class ContactListRest {
    private static final String CONTACT_LIST = "/account/{accountId}/contactlist";
    private static final String CONTACT_LIST_CREATE = "/account/{accountId}/contactlist";
    private static final String CONTACT_LIST_ITEM = "/account/{accountId}/contact/{contactListId}";
    private static final String CONTACT_LIST_ITEM_UPDATE = "/account/{accountId}/contact/{contactListId}";
    private static final String CONTACT_LIST_ITEM_DELETE = "/account/{accountId}/contact/{contactListId}";
    private static final String EXECUTE = "/account/{accountId}/contactList/{contactListId}/execute?getCount=false";
    private static final String EXECUTE_COUNT = "/account/{accountId}/contactList/{contactListId}/execute?getCount=true";
    private static final String EXECUTE_SUBSCRIPTIONLESS = "/account/{accountId}/contactList/{contactListId}/subscription-execute?getCount=false";
    private static final String EXECUTE_SUBSCRIPTION = "/account/{accountId}/contactList/{contactListId}/subscription-execute/{subscriptionId}?getCount={getCount}";
    private static final String EXECUTE_SUBSCRIPTIONLESS_COUNT = "/account/{accountId}/contactList/{contactListId}/subscription-execute?getCount=true";

    public interface ContactListService {
        @GET(EXECUTE_SUBSCRIPTION)
        Call<List<Contact>> getContactsSubscribedTo(@Path("accountId") int accountId, @Path("contactListId") int contactListId, @Path("subscriptionId") int subscriptionId, @Path("getCount") boolean getCount);

        @GET(EXECUTE_SUBSCRIPTIONLESS)
        Call<List<Contact>> getTotalContacts(@Path("accountId") int accountId, @Path("contactListId") int contactListId);

        @GET(EXECUTE)
        Call<List<Contact>> getContacts(@Path("accountId") int accountId, @Path("contactListId") int contactListId);

        @GET(CONTACT_LIST)
        Call<List<ContactList>> getList(@Path("accountId") int accountId);

        @GET(CONTACT_LIST_ITEM)
        Call<ContactList> getById(@Path("accountId") int accountId, @Path("contactListId") int contactListId);

        @POST(CONTACT_LIST_CREATE)
        Call<ContactList> create(@Path("accountId") int accountId, @Body ContactList contactList);

        @PUT(CONTACT_LIST_ITEM_UPDATE)
        Call<ContactList> update(@Path("accountId") int accountId, @Path("contactListId") int contactListId, @Body ContactList contactList);

        @DELETE(CONTACT_LIST_ITEM_DELETE)
        Call<Void> delete(@Path("accountId") int accountId, @Path("contactListId") int contactListId);

        @GET(EXECUTE_SUBSCRIPTIONLESS_COUNT)
        Call<Integer> getTotalCount(@Path("accountId") int accountId, @Path("contactListId") int contactListId);

        @GET(EXECUTE_COUNT)
        Call<Integer> getCount(@Path("accountId") int accountId, @Path("contactListId") int contactListId);
    }
}
