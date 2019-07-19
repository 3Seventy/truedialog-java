package com.truedialog.client.context.account;


import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.account.AccountAttribute;
import com.truedialog.client.rest.account.AccountAttributeRest;

import java.util.List;

public class AccountAttributeContext extends BaseContext {

    private AccountAttributeRest.AccountAttributeService accountAttributeService;

    public AccountAttributeContext(TrueDialogClient trueDialogClient, AccountAttributeRest.AccountAttributeService accountAttributeService) {
        super(trueDialogClient);
        this.accountAttributeService = accountAttributeService;
    }

    public List<AccountAttribute> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<AccountAttribute> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<AccountAttribute> getList(int accountId) {
        return executeEntityListCall(accountAttributeService.getAttributeList(accountId));

    }

    public List<AccountAttribute> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(accountAttributeService.getAttributeList(accountId), throwIfEmpty);

    }

    public AccountAttribute getById(int accountId, int attributeId, boolean throwIfEmpty) {
        String value = executeEntityCall(accountAttributeService.getAccountAttributeById(accountId, attributeId), throwIfEmpty);
        AccountAttribute accountAttribute = new AccountAttribute();
        accountAttribute.setAccountId(accountId);
        accountAttribute.setId(attributeId);
        accountAttribute.setValue(value);
        return accountAttribute;
    }

    public AccountAttribute getByName(int accountId, String attributeName, boolean throwIfEmpty) {
        String value = executeEntityCall(accountAttributeService.getAccountAttributeByName(accountId, attributeName), throwIfEmpty);
        AccountAttribute accountAttribute = new AccountAttribute();
        accountAttribute.setAccountId(accountId);
        accountAttribute.setName(attributeName);
        accountAttribute.setValue(value);
        return accountAttribute;
    }

    public AccountAttribute create(int accountId, AccountAttribute attribute) {
        String nameOrId = attribute.getId() > 0 ? String.valueOf(attribute.getId()) : attribute.getName();

        return executeEntityCall(accountAttributeService.createAttribute(accountId, nameOrId, attribute.getValue()), true);
    }

    public AccountAttribute create(AccountAttribute attribute) {
        return create(trueDialogClient.getCurrentAccount(), attribute);
    }

    public AccountAttribute update(AccountAttribute attribute) {
        return executeEntityCall(accountAttributeService.updateAttribute(attribute.getAccountId(), attribute.getId(), attribute.getValue()));
    }

    public void delete(int accountId, int attributeId) {
        executeEntityCall(accountAttributeService.deleteAttribute(accountId, attributeId), true);
    }

    public void delete(int accountId, String attributeName) {
        executeEntityCall(accountAttributeService.deleteAttribute(accountId, attributeName), true);
    }

    public void delete(AccountAttribute attribute) {
        if (attribute.getId() > 0)
            delete(attribute.getAccountId(), attribute.getId());
        else
            delete(attribute.getAccountId(), attribute.getName());
    }

    public void delete(int attributeId) {
        delete(trueDialogClient.getCurrentAccount(), attributeId);
    }

    public void delete(String attributeName) {
        delete(trueDialogClient.getCurrentAccount(), attributeName);
    }


}
