package com.truedialog.client.context.contact;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.contact.Contact;
import com.truedialog.client.rest.contact.ContactAttributeDefinitionRest;
import com.truedialog.client.rest.contact.ContactAttributeRest;
import com.truedialog.client.rest.contact.ContactRest;
import com.truedialog.client.rest.contact.ContactSubscriptionRest;

import java.util.List;

public class ContactContext extends BaseContext {

    private ContactRest.ContactService contactService;
    private ContactAttributeRest.ContactAttributeService contactAttributeService;
    private ContactAttributeDefinitionRest.ContactAttributeDefinitionService contactAttributeDefinitionService;
    private ContactSubscriptionRest.ContactSubscriptionService contactSubscriptionService;
    public ContactContext(TrueDialogClient trueDialogClient,
                          ContactRest.ContactService contactService,
                          ContactAttributeRest.ContactAttributeService contactAttributeService,
                          ContactAttributeDefinitionRest.ContactAttributeDefinitionService contactAttributeDefinitionService,
                          ContactSubscriptionRest.ContactSubscriptionService contactSubscriptionService) {
        super(trueDialogClient);
        this.contactService = contactService;
        this.contactAttributeService = contactAttributeService;
        this.contactAttributeDefinitionService = contactAttributeDefinitionService;
        this.contactSubscriptionService = contactSubscriptionService;
    }

    public ContactAttributeContext getContactAttributeContext() {
        return new ContactAttributeContext(trueDialogClient, contactAttributeService);
    }

    public ContactAttributeDefinitionContext getContactAttributeDefinitionContext() {
        return new ContactAttributeDefinitionContext(trueDialogClient, contactAttributeDefinitionService);
    }

    public ContactSubscriptionContext getContactSubscriptionContext() {
        return new ContactSubscriptionContext(trueDialogClient, contactSubscriptionService);
    }

    /**
     * Get contact by contact Id
     */
    public Contact getById(int accountId, int contactId) {
        return executeEntityCall(contactService.getContactById(accountId, contactId));

    }

    public Contact getById(int accountId, int contactId, boolean throwIfEmpty) {
        return executeEntityCall(contactService.getContactById(accountId, contactId), throwIfEmpty);
    }

    public Contact getById(int contactId) {
        return getById(trueDialogClient.getCurrentAccount(), contactId);

    }

    public Contact getById(int contactId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), contactId, throwIfEmpty);
    }

    /**
     * Getting list of all contacts
     */

    public List<Contact> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<Contact> getList(int accountId) {
        return executeEntityListCall(contactService.getContactList(accountId));
    }

    public List<Contact> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<Contact> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(contactService.getContactList(accountId), throwIfEmpty);
    }

    /**
     * Searching contacts by needle
     */

    public List<Contact> search(String needle) {
        return search(trueDialogClient.getCurrentAccount(), needle);
    }

    public List<Contact> search(int accountId, String needle) {
        return executeEntityCall(contactService.searchContact(accountId, needle), false);
    }

    /**
     * Adding contact
     */

    public Contact create(Contact contact) {
        return create(contact.getAccountId() > 0 ? contact.getAccountId() : trueDialogClient.getCurrentAccount(), contact);
    }

    public Contact create(int accountId, Contact contact) {
        return executeEntityCall(contactService.addContact(accountId, contact), true);
    }

    /**
     * Updating contact
     */

    public Contact update(Contact contact) {
        return update(contact.getAccountId() > 0 ? contact.getAccountId() : trueDialogClient.getCurrentAccount(), contact.getId(), contact);
    }

    public Contact update(int accountId, int contactId, Contact contact) {
        return executeEntityCall(contactService.updateContact(accountId, contactId, contact), true);
    }

    public Contact update(int accountId, Contact contact) {
        return update(accountId, contact.getId(), contact);
    }


}
