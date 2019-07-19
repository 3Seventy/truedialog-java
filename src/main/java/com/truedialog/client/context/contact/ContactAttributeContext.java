package com.truedialog.client.context.contact;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.contact.ContactAttribute;
import com.truedialog.client.model.subscription.ContactSubscription;
import com.truedialog.client.rest.contact.ContactAttributeDefinitionRest;
import com.truedialog.client.rest.contact.ContactAttributeRest;
import com.truedialog.client.rest.contact.ContactRest;
import com.truedialog.client.rest.contact.ContactSubscriptionRest;

import java.util.List;

public class ContactAttributeContext extends BaseContext {

    private ContactAttributeRest.ContactAttributeService contactAttributeService;


    ContactAttributeContext(TrueDialogClient trueDialogClient, ContactAttributeRest.ContactAttributeService contactAttributeService) {
        super(trueDialogClient);
        this.contactAttributeService = contactAttributeService;
    }

    public ContactAttribute getByName(int contactId, String name) {
        return executeEntityCall(contactAttributeService.getContactAttributeByName(trueDialogClient.getCurrentAccount(), contactId, name));
    }

    public ContactAttribute getByName(int contactId, String name, boolean throwIfEmpty) {
        return executeEntityCall(contactAttributeService.getContactAttributeByName(trueDialogClient.getCurrentAccount(), contactId, name), throwIfEmpty);

    }

    public ContactAttribute getByName(int accountId, int contactId, String name) {
        return executeEntityCall(contactAttributeService.getContactAttributeByName(accountId, contactId, name));
    }

    public ContactAttribute getByName(int accountId, int contactId, String name, boolean throwIfEmpty) {
        return executeEntityCall(contactAttributeService.getContactAttributeByName(accountId, contactId, name), throwIfEmpty);
    }


    public List<ContactAttribute> getList(int contactId) {
        return executeEntityListCall(contactAttributeService.getContactAttributeList(trueDialogClient.getCurrentAccount(), contactId));
    }

    public List<ContactAttribute> getList(int contactId, boolean throwIfEmpty) {
        return executeEntityListCall(contactAttributeService.getContactAttributeList(trueDialogClient.getCurrentAccount(), contactId), throwIfEmpty);
    }

    public List<ContactAttribute> getList(int accountId, int contactId) {
        return executeEntityListCall(contactAttributeService.getContactAttributeList(contactId, contactId));

    }

    public List<ContactAttribute> getList(int accountId, int contactId, boolean throwIfEmpty) {
        return executeEntityListCall(contactAttributeService.getContactAttributeList(contactId, contactId), throwIfEmpty);

    }

    public ContactAttribute createOrUpdate(int accountId, int contactId, String name, String value) {
        return executeEntityCall(contactAttributeService.createContactAttribute(accountId, contactId, name, value));
    }

    public ContactAttribute createOrUpdate(int contactId, String name, String value) {
        return createOrUpdate(trueDialogClient.getCurrentAccount(), contactId, name, value);
    }

    public ContactAttribute createOrUpdate(int contactId, ContactAttribute attribute) {
        String name = attribute.getId() > 0 ? String.valueOf(attribute.getId()) : attribute.getName();
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Attribute name is missing.");

        return createOrUpdate(trueDialogClient.getCurrentAccount(), contactId, name, attribute.getValue());
    }

    public ContactAttribute createOrUpdate(ContactAttribute attribute) {
        if (attribute.contactId == 0)
            throw new IllegalArgumentException("Contact ID is missing");

        return createOrUpdate(attribute.contactId, attribute);
    }


    public void delete(int accountId, int contactId, String name) {
        executeEntityCall(contactAttributeService.deleteContactAttribute(accountId, contactId, name));
    }

    public void delete(int contactId, String name) {
        executeEntityCall(contactAttributeService.deleteContactAttribute(trueDialogClient.getCurrentAccount(), contactId, name));
    }

    public void delete(ContactAttribute attribute) {
        if (attribute.contactId == 0)
            throw new IllegalArgumentException("Contact ID is missing.");

        String name = attribute.getId() > 0 ? String.valueOf(attribute.getId()) : attribute.getName();
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Attribute name is missing.");
        delete(attribute.contactId, name);

    }


}
