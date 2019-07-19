package com.truedialog.client.context.callback;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.enums.CallbackType;
import com.truedialog.client.model.callback.Callback;
import com.truedialog.client.rest.callback.CallbackRest;

import java.util.List;

public class CallbackContext extends BaseContext {

    private CallbackRest.CallbackService callbackService;

    public CallbackContext(TrueDialogClient trueDialogClient, CallbackRest.CallbackService callbackService) {
        super(trueDialogClient);
        this.callbackService = callbackService;
    }

    public List<Callback> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<Callback> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<Callback> getList(int accountId) {
        return executeEntityListCall(callbackService.getCallbackList(accountId));
    }

    public List<Callback> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(callbackService.getCallbackList(accountId), throwIfEmpty);
    }

    //GET
    public Callback getById(int callbackId) {
        return getById(trueDialogClient.getCurrentAccount(), callbackId);
    }

    public Callback getById(int callbackId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), callbackId, throwIfEmpty);
    }

    public Callback getById(int accountId, int callbackId) {
        return executeEntityCall(callbackService.getCallback(accountId, callbackId));
    }

    public Callback getById(int accountId, int callbackId, boolean throwIfEmpty) {
        return executeEntityCall(callbackService.getCallback(accountId, callbackId), throwIfEmpty);
    }

    // CREATE
    public Callback create(Callback callback) {
        return create(trueDialogClient.getCurrentAccount(), callback);
    }

    public Callback create(int accountId, Callback callback) {
        return executeEntityCall(callbackService.createCallback(accountId, callback), true);
    }

    public Callback create(int accountId, CallbackType type, String url) {
        Callback callback = new Callback();
        callback.setCallbackType(type);
        callback.setUrl(url);
        callback.setActive(true);
        return create(accountId, callback);
    }

    public Callback create(CallbackType type, String url) {
        return create(trueDialogClient.getCurrentAccount(), type, url);
    }

    public Callback update(int accountId, int callbackId, Callback callback) {
        return executeEntityCall(callbackService.updateCallback(accountId, callbackId, callback), true);
    }

    public Callback update(int callbackId, Callback callback) {
        return update(trueDialogClient.getCurrentAccount(), callbackId, callback);
    }

    public Callback updateUrl(int accountId, int callbackId, String newUrl) {
        Callback callback = new Callback();
        callback.setUrl(newUrl);
        callback.setActive(true);
        return update(accountId, callbackId, callback);
    }

    public Callback updateUrl(int callbackId, String newUrl) {
        return updateUrl(trueDialogClient.getCurrentAccount(), callbackId, newUrl);
    }

    public Callback disable(Callback callback) {
        if (callback.getId() == 0)
            throw new IllegalArgumentException("Callback ID is missing.");

        if ((callback.getUrl() == null || callback.getUrl().isEmpty()))
            throw new IllegalArgumentException("Callback URL is missing.");

        int accountId = callback.getAccountId() > 0 ? callback.getAccountId() : trueDialogClient.getCurrentAccount();

        callback.setActive(false);
        return update(accountId, callback.getId(), callback);
    }

    public void delete(int accountId, int callbackId) {
        executeEntityCall(callbackService.deleteCallback(accountId, callbackId), true);
    }

    public void delete(int callbackId) {
        delete(trueDialogClient.getCurrentAccount(), callbackId);
    }

    public void delete(Callback callback) {
        if (callback.getId() == 0)
            throw new IllegalArgumentException("Callback ID is missing.");

        int accountId = callback.getAccountId() > 0 ? callback.getAccountId() : trueDialogClient.getCurrentAccount();
        delete(accountId, callback.getId());
    }
}
