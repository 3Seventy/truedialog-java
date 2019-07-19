package com.truedialog.client.context.contact;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.subscription.ContactSubscription;
import com.truedialog.client.rest.contact.ContactRest;
import com.truedialog.client.rest.contact.ContactSubscriptionRest;

import java.util.List;

public class ContactSubscriptionContext extends BaseContext {

    private ContactSubscriptionRest.ContactSubscriptionService contactSubscriptionService;


    ContactSubscriptionContext(TrueDialogClient trueDialogClient, ContactSubscriptionRest.ContactSubscriptionService contactSubscriptionService) {
        super(trueDialogClient);
        this.contactSubscriptionService = contactSubscriptionService;
    }

    public ContactSubscription getById(int accountId, int contactId, int subscriptionId) {
        return executeEntityCall(contactSubscriptionService.getContactSubscriptionById(accountId, contactId, subscriptionId));
    }

    public ContactSubscription getById(int accountId, int contactId, int subscriptionId, boolean throwIfEmpty) {
        return executeEntityCall(contactSubscriptionService.getContactSubscriptionById(accountId, contactId, subscriptionId), throwIfEmpty);

    }

    public ContactSubscription getById(int contactId, int subscriptionId) {
        return executeEntityCall(contactSubscriptionService.getContactSubscriptionById(trueDialogClient.getCurrentAccount(), contactId, subscriptionId));
    }

    public ContactSubscription getById(int contactId, int subscriptionId, boolean throwIfEmpty) {
        return executeEntityCall(contactSubscriptionService.getContactSubscriptionById(trueDialogClient.getCurrentAccount(), contactId, subscriptionId), throwIfEmpty);


    }

    public List<ContactSubscription> getList(int accountId, int contactId) {
        return executeEntityListCall(contactSubscriptionService.getContactSubscriptionList(accountId, contactId));
    }

    public List<ContactSubscription> getList(int accountId, int contactId, boolean throwIfEmpty) {
        return executeEntityListCall(contactSubscriptionService.getContactSubscriptionList(accountId, contactId), throwIfEmpty);
    }

    public List<ContactSubscription> getList(int contactId) {
        return executeEntityListCall(contactSubscriptionService.getContactSubscriptionList(trueDialogClient.getCurrentAccount(), contactId));
    }

    public List<ContactSubscription> getList(int contactId, boolean throwIfEmpty) {
        return executeEntityListCall(contactSubscriptionService.getContactSubscriptionList(trueDialogClient.getCurrentAccount(), contactId), throwIfEmpty);
    }

}
