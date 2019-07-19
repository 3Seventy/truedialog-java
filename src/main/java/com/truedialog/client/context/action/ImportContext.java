package com.truedialog.client.context.action;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.action.ActionImportContacts;
import com.truedialog.client.model.subscription.ContactSubscription;
import com.truedialog.client.rest.action.ImportRest;

import java.util.List;

public class ImportContext extends BaseContext {

    private ImportRest.ImportService importService;

    public ImportContext(TrueDialogClient trueDialogClient, ImportRest.ImportService importService) {
        super(trueDialogClient);
        this.importService = importService;
    }

    // List
    public List<ActionImportContacts> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<ActionImportContacts> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<ActionImportContacts> getList(int accountId) {
        return executeEntityListCall(importService.getImportList(accountId));
    }

    public List<ActionImportContacts> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(importService.getImportList(accountId), throwIfEmpty);
    }

    // By id
    public ActionImportContacts getById(int actionId) {
        return getById(trueDialogClient.getCurrentAccount(), actionId);
    }

    public ActionImportContacts getById(int actionId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), actionId, throwIfEmpty);
    }

    public ActionImportContacts getById(int accountId, int actionId) {
        return executeEntityCall(importService.getImport(accountId, actionId));
    }

    public ActionImportContacts getById(int accountId, int actionId, boolean throwIfEmpty) {
        return executeEntityCall(importService.getImport(accountId, actionId), throwIfEmpty);
    }


    public ActionImportContacts create(int accountId, ActionImportContacts action) {
        return executeEntityCall(importService.createImport(accountId, action), true);
    }

    public ActionImportContacts create(ActionImportContacts action) {
        return create(trueDialogClient.getCurrentAccount(), action);
    }

    public ActionImportContacts importAction(int accountId, String url, List<ContactSubscription> subscriptions) {
        ActionImportContacts action = new ActionImportContacts();
        action.setUrl(url);
        action.setSubscriptions(subscriptions);
        action.setExecute(true);
        return create(accountId, action);
    }

    public ActionImportContacts importAction(String url, List<ContactSubscription> subscriptions) {
        return importAction(trueDialogClient.getCurrentAccount(), url, subscriptions);
    }

    public void stop(int accountId, int actionId) {
        executeEntityCall(importService.stopImport(accountId, actionId), true);
    }

    public void stop(int actionId) {
        stop(trueDialogClient.getCurrentAccount(), actionId);
    }
}
