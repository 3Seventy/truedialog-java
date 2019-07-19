package com.truedialog.client.context.account;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.account.AccountAttributeDefinition;
import com.truedialog.client.rest.account.AccountAttributeDefinitionRest;

import java.util.List;

public class AccountAttributeDefinitionContext extends BaseContext {

    private AccountAttributeDefinitionRest.AccountAttributeDefinitionService accountAttributeDefinitionService;

    public AccountAttributeDefinitionContext(TrueDialogClient trueDialogClient, AccountAttributeDefinitionRest.AccountAttributeDefinitionService accountAttributeDefinitionService) {
        super(trueDialogClient);
        this.accountAttributeDefinitionService = accountAttributeDefinitionService;
    }

    public AccountAttributeDefinition getById(int definitionId) {
        return getById(trueDialogClient.getCurrentAccount(), definitionId);
    }

    public AccountAttributeDefinition getById(int definitionId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), definitionId, throwIfEmpty);
    }

    public AccountAttributeDefinition getById(int accountId, int definitionId) {
        return executeEntityCall(accountAttributeDefinitionService.getAccountAttributeDefinition(accountId, definitionId));
    }

    public AccountAttributeDefinition getById(int accountId, int definitionId, boolean throwIfEmpty) {
        return executeEntityCall(accountAttributeDefinitionService.getAccountAttributeDefinition(accountId, definitionId), throwIfEmpty);
    }


    public List<AccountAttributeDefinition> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<AccountAttributeDefinition> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<AccountAttributeDefinition> getList(int accountId) {
        return executeEntityListCall(accountAttributeDefinitionService.getAccountAttributeDefinitionList(accountId));
    }

    public List<AccountAttributeDefinition> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(accountAttributeDefinitionService.getAccountAttributeDefinitionList(accountId), throwIfEmpty);
    }

    public AccountAttributeDefinition add(AccountAttributeDefinition definition) {
        return add(trueDialogClient.getCurrentAccount(), definition);
    }

    public AccountAttributeDefinition add(int accountId, AccountAttributeDefinition definition) {
        return executeEntityCall(accountAttributeDefinitionService.addAccountAttributeDefinition(accountId, definition), true);
    }

    public void delete(int accountId, int definitionId) {
        executeEntityCall(accountAttributeDefinitionService.deleteAccountAttributeDefinition(accountId, definitionId), true);
    }

    public void delete(AccountAttributeDefinition definition) {
        delete(definition.getAccountId(), definition.getId());
    }

    public void delete(int definitionId) {
        delete(trueDialogClient.getCurrentAccount(), definitionId);
    }
}
