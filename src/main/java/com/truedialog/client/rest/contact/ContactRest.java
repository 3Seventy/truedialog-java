package com.truedialog.client.rest.contact;

import com.truedialog.client.model.contact.Contact;
import com.truedialog.client.model.contact.ContactAttribute;
import com.truedialog.client.model.contact.ContactAttributeDefinition;
import com.truedialog.client.model.subscription.ContactSubscription;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public class ContactRest {


    private static final String CONTACT_ITEM = "account/{accountId}/contact/{contactId}";
    private static final String CONTACT_UPDATE = "account/{accountId}/contact/{contactId}";
    private static final String CONTACT_LIST = "account/{accountId}/contact";
    private static final String CONTACT_ADD = "account/{accountId}/contact";
    private static final String CONTACT_SEARCH = "account/{accountId}/contact-search";


    public interface ContactService {


        @GET(CONTACT_ITEM)
        Call<Contact> getContactById(@Path("accountId") int accountId, @Path("contactId") int contactId);

        @POST(CONTACT_UPDATE)
        Call<Contact> updateContact(@Path("accountId") int accountId, @Path("contactId") int contactId, @Body Contact contact);

        @GET(CONTACT_LIST)
        Call<List<Contact>> getContactList(@Path("accountId") int accountId);

        @POST(CONTACT_ADD)
        Call<Contact> addContact(@Path("accountId") int accountId, @Body Contact contact);

        @POST(CONTACT_SEARCH)
        Call<List<Contact>> searchContact(@Path("accountId") int accountId, @Body String needle);

        }
}
