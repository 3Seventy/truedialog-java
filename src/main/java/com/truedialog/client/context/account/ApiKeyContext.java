package com.truedialog.client.context.account;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.enums.ApiKeyType;
import com.truedialog.client.model.account.ApiKey;
import com.truedialog.client.rest.account.ApiKeyRest;

import java.util.Date;
import java.util.List;

public class ApiKeyContext extends BaseContext {

    private ApiKeyRest.ApiKeyService apiKeyService;

    public ApiKeyContext(TrueDialogClient trueDialogClient, ApiKeyRest.ApiKeyService apiKeyService) {
        super(trueDialogClient);
        this.apiKeyService = apiKeyService;
    }

    public List<ApiKey> getList(int accountId) {
        return executeEntityCall(apiKeyService.getApiKeyList(accountId));
    }

    public List<ApiKey> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityCall(apiKeyService.getApiKeyList(accountId), throwIfEmpty);
    }

    public List<ApiKey> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<ApiKey> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public ApiKey getById(int keyId) {
        return getById(trueDialogClient.getCurrentAccount(), keyId);
    }

    public ApiKey getById(int keyId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), keyId, throwIfEmpty);
    }

    public ApiKey getById(int accountId, int keyId) {
        return executeEntityCall(apiKeyService.getApiKey(accountId, keyId));
    }

    public ApiKey getById(int accountId, int keyId, boolean throwIfEmpty) {
        return executeEntityCall(apiKeyService.getApiKey(accountId, keyId), throwIfEmpty);
    }

    private ApiKey create(int accountId, ApiKey key) {
        return executeEntityCall(apiKeyService.createApiKey(accountId, key), true);
    }

    public ApiKey createTemporary(int accountId, String label, Date validTo) {
        ApiKey apiKey = new ApiKey();
        apiKey.setLabel(label);
        apiKey.setValidTo(validTo);
        apiKey.setType(ApiKeyType.TEMPORARY);
        return create(accountId, apiKey);
    }

    public ApiKey createTemporary(String label, Date validTo) {
        return createTemporary(trueDialogClient.getCurrentAccount(), label, validTo);
    }

    public ApiKey createCommon(int accountId, String label) {
        ApiKey apiKey = new ApiKey();
        apiKey.setLabel(label);
        return create(accountId, apiKey);
    }

    public ApiKey createCommon(String label) {
        return createCommon(trueDialogClient.getCurrentAccount(), label);
    }

    public ApiKey updateSecret(int accountId, int keyId) {
        return executeEntityCall(apiKeyService.updateSecret(accountId, keyId), true);
    }

    public ApiKey updateSecret(ApiKey key) {
        return updateSecret(key.getAccountId(), key.getId());
    }

    public ApiKey updateSecret(int keyId) {
        return updateSecret(trueDialogClient.getCurrentAccount(), keyId);
    }

    public void revoke(int accountId, int keyId) {
        apiKeyService.revoke(accountId, keyId);
    }

    public void revoke(ApiKey key) {
        revoke(key.getAccountId(), key.getId());
    }

    public void revoke(int keyId) {
        revoke(trueDialogClient.getCurrentAccount(), keyId);
    }


}
