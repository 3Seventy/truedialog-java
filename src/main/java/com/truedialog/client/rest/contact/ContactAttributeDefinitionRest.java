package com.truedialog.client.rest.contact;

import com.truedialog.client.model.contact.ContactAttributeDefinition;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class ContactAttributeDefinitionRest {
    private static final String CONTACT_ATTRIBUTE_DEFINITION_ITEM = "account/{accountId}/contact-attributedef/{definitionId}";
    private static final String CONTACT_ATTRIBUTE_DEFINITION_LIST = "account/{accountId}/contact-attributedef";
    private static final String CONTACT_ATTRIBUTE_DEFINITION_CREATE = "account/{accountId}/contact-attributedef/{definitionId}";
    private static final String CONTACT_ATTRIBUTE_DEFINITION_UPDATE = "account/{accountId}/contact-attributedef/{definitionId}";
    private static final String CONTACT_ATTRIBUTE_DEFINITION_DELETE = "account/{accountId}/contact-attributedef/{definitionId}";


    public interface ContactAttributeDefinitionService {
        @GET(CONTACT_ATTRIBUTE_DEFINITION_ITEM)
        Call<ContactAttributeDefinition> getContactAttributeDefinitionById(@Path("accountId") int accountId, @Path("definitionId") int definitionId);

        @GET(CONTACT_ATTRIBUTE_DEFINITION_LIST)
        Call<List<ContactAttributeDefinition>> getContactAttributeDefinitionContextList(@Path("accountId") int accountId);

        @POST(CONTACT_ATTRIBUTE_DEFINITION_CREATE)
        Call<ContactAttributeDefinition> createContactAttributeDefinition(@Path("accountId") int accountId, @Body ContactAttributeDefinition contactAttributeDefinition);

        @PUT(CONTACT_ATTRIBUTE_DEFINITION_UPDATE)
        Call<ContactAttributeDefinition> updateContactAttributeDefinition(@Path("accountId") int accountId, @Path("definitionId") int definitionId, @Body String description);

        @DELETE(CONTACT_ATTRIBUTE_DEFINITION_DELETE)
        Call<ContactAttributeDefinition> delete(@Path("accountId") int accountId, @Path("definitionId") int definitionId);

    }
}
