package com.truedialog.client.context.contactlist;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.contact.Contact;
import com.truedialog.client.model.filter.ContactList;
import com.truedialog.client.rest.contactlist.ContactListRest;

import java.util.List;

public class ContactListContext extends BaseContext {
    private ContactListRest.ContactListService contactListService;

    public ContactListContext(TrueDialogClient trueDialogClient, ContactListRest.ContactListService contactListService) {
        super(trueDialogClient);
        this.contactListService = contactListService;
    }

    public List<Contact> getContactsSubscribedTo(int accountId, int contactListId, int subscriptionId) {
        return executeEntityListCall(contactListService.getContactsSubscribedTo(accountId, contactListId, subscriptionId, false));
    }

    public List<Contact> getContactsSubscribedTo(int accountId, int contactListId, int subscriptionId, boolean throwIfEmpty) {
        return executeEntityListCall(contactListService.getContactsSubscribedTo(accountId, contactListId, subscriptionId, false), throwIfEmpty);
    }

    public List<Contact> getContactsSubscribedTo(int contactListId, int subscriptionId) {
        return getContactsSubscribedTo(trueDialogClient.getCurrentAccount(), contactListId, subscriptionId);
    }

    public List<Contact> getContactsSubscribedTo(int contactListId, int subscriptionId, boolean throwIfEmpty) {
        return getContactsSubscribedTo(trueDialogClient.getCurrentAccount(), contactListId, subscriptionId, throwIfEmpty);
    }

    public List<Contact> getTotalContacts(int accountId, int contactListId) {
        return executeEntityListCall(contactListService.getTotalContacts(accountId, contactListId));
    }

    public List<Contact> getTotalContacts(int contactListId) {
        return getTotalContacts(trueDialogClient.getCurrentAccount(), contactListId);
    }

    public List<Contact> getTotalContacts(int accountId, int contactListId, boolean throwIfEmpty) {
        return executeEntityListCall(contactListService.getTotalContacts(accountId, contactListId), throwIfEmpty);

    }

    public List<Contact> getTotalContacts(int contactListId, boolean throwIfEmpty) {
        return getTotalContacts(trueDialogClient.getCurrentAccount(), contactListId, throwIfEmpty);

    }

    public int getTotalCount(int accountId, int contactListId) {
        return executeEntityCall(contactListService.getTotalCount(accountId, contactListId));
    }

    public int getTotalCount(int contactListId) {
        return getTotalCount(trueDialogClient.getCurrentAccount(), contactListId);
    }

    public List<Contact> getContacts(int accountId, int contactListId) {
        return executeEntityListCall(contactListService.getContacts(accountId, contactListId));
    }

    public List<Contact> getContacts(int accountId, int contactListId, boolean throwIfEmpty) {
        return executeEntityListCall(contactListService.getContacts(accountId, contactListId), throwIfEmpty);
    }

    public List<Contact> getContacts(int contactListId) {
        return getContacts(trueDialogClient.getCurrentAccount(), contactListId);
    }

    public List<Contact> getContacts(int contactListId, boolean throwIfEmpty) {
        return getContacts(trueDialogClient.getCurrentAccount(), contactListId, throwIfEmpty);
    }

    public int getCount(int accountId, int contactListId) {
        return executeEntityCall(contactListService.getCount(accountId, contactListId));
    }

    public int getCount(int contactListId) {
        return getCount(trueDialogClient.getCurrentAccount(), contactListId);
    }

    public List<ContactList> getList(int accountId) {
        return executeEntityListCall(contactListService.getList(accountId));
    }

    public List<ContactList> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(contactListService.getList(accountId), throwIfEmpty);
    }

    public List<ContactList> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<ContactList> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public ContactList getById(int accountId, int contactListId) {
        return executeEntityCall(contactListService.getById(accountId, contactListId));
    }

    public ContactList getById(int accountId, int contactListId, boolean throwIfEmpty) {
        return executeEntityCall(contactListService.getById(accountId, contactListId), throwIfEmpty);
    }

    public ContactList getById(int contactListId) {
        return getById(trueDialogClient.getCurrentAccount(), contactListId);
    }

    public ContactList getById(int contactListId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), contactListId, throwIfEmpty);
    }

    public ContactList create(int accountId, ContactList contactList) {
        return executeEntityCall(contactListService.create(accountId, contactList));
    }

    public ContactList create(ContactList contactList) {
        return create(trueDialogClient.getCurrentAccount(), contactList);
    }

    public ContactList update(int accountId, int contactListId, ContactList contactList) {
        return executeEntityCall(contactListService.update(accountId, contactListId, contactList));
    }

    public ContactList update(int contactListId, ContactList contactList) {
        return update(trueDialogClient.getCurrentAccount(), contactListId, contactList);
    }

    public ContactList update(ContactList contactList) {
        if (contactList.getId() == 0)
            throw new IllegalArgumentException("Contact list ID is missing.");
        int accountId = contactList.getId() > 0 ? contactList.getId() : trueDialogClient.getCurrentAccount();

        return update(accountId, contactList.getId(), contactList);
    }

    public void delete(int accountId, int contactListId) {
        executeEntityCall(contactListService.delete(accountId, contactListId));
    }

    public void delete(int contactListId) {
        delete(trueDialogClient.getCurrentAccount(), contactListId);
    }

    public void delete(ContactList contactList) {
        if (contactList.getId() == 0)
            throw new IllegalArgumentException("Contact list ID is missing.");
        int accountId = contactList.getId() > 0 ? contactList.getId() : trueDialogClient.getCurrentAccount();
        delete(accountId, contactList.getId());
    }

}
