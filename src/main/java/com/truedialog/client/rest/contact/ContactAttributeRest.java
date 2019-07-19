package com.truedialog.client.rest.contact;

import com.truedialog.client.model.contact.ContactAttribute;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class ContactAttributeRest {

    private static final String CONTACT_ATTRIBUTE_LIST = "account/{accountId}/contact/{contactId}/attribute";
    private static final String CONTACT_ATTRIBUTE_ITEM = "account/{accountId}/contact/{contactId}/attribute/{name}";
    private static final String CONTACT_ATTRIBUTE_CREATE = "account/{accountId}/contact/{contactId}/attribute/{name}";
    private static final String CONTACT_ATTRIBUTE_UPDATE = "account/{accountId}/contact/{contactId}/attribute/{name}";
    private static final String CONTACT_ATTRIBUTE_DELETE = "account/{accountId}/contact/{contactId}/attribute/{name}";

    public interface ContactAttributeService {
        @GET(CONTACT_ATTRIBUTE_LIST)
        Call<List<ContactAttribute>> getContactAttributeList(@Path("accountId") int accountId, @Path("contactId") int contactId);

        @GET(CONTACT_ATTRIBUTE_ITEM)
        Call<ContactAttribute> getContactAttributeByName(@Path("accountId") int accountId, @Path("contactId") int contactId, @Path("name") String name);


        @POST(CONTACT_ATTRIBUTE_CREATE)
        Call<ContactAttribute> createContactAttribute(@Path("accountId") int accountId, @Path("contactId") int contactId,@Path("name") String name, @Body Object value);

        @POST(CONTACT_ATTRIBUTE_UPDATE)
        Call<ContactAttribute> updateContactAttribute(@Path("accountId") int accountId, @Path("contactId") int contactId,@Path("name") String name, @Body Object value);

        @DELETE(CONTACT_ATTRIBUTE_DELETE)
        Call<ContactAttribute> deleteContactAttribute(@Path("accountId") int accountId, @Path("contactId") int contactId, @Path("name") String name);
    }
}
