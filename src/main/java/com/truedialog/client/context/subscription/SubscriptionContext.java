package com.truedialog.client.context.subscription;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.subscription.Subscription;
import com.truedialog.client.rest.subscription.SubscriptionRest;

import java.util.List;

public class SubscriptionContext extends BaseContext {

    private SubscriptionRest.SubscriptionService subscriptionService;

    public SubscriptionContext(TrueDialogClient trueDialogClient, SubscriptionRest.SubscriptionService subscriptionService) {
        super(trueDialogClient);
        this.subscriptionService = subscriptionService;
    }

    public List<Subscription> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<Subscription> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<Subscription> getList(int accountId) {
        return executeEntityListCall(subscriptionService.getSubscriptionList(accountId));
    }

    public List<Subscription> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(subscriptionService.getSubscriptionList(accountId), throwIfEmpty);
    }

    public Subscription getById(int accountId, int subscriptionId) {
        return executeEntityCall(subscriptionService.getSubscriptionById(accountId, subscriptionId));
    }

    public Subscription getById(int accountId, int subscriptionId, boolean throwIfEmpty) {
        return executeEntityCall(subscriptionService.getSubscriptionById(accountId, subscriptionId), throwIfEmpty);
    }

    public Subscription getById(int subscriptionId) {
        return getById(trueDialogClient.getCurrentAccount(), subscriptionId);
    }

    public Subscription getById(int subscriptionId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), subscriptionId, throwIfEmpty);
    }

}
