package com.truedialog.client.context.account;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.account.Account;
import com.truedialog.client.rest.account.AccountAttributeRest;
import com.truedialog.client.rest.account.AccountRest;

import java.util.List;

public class AccountContext extends BaseContext {

    private AccountRest.AccountService accountService;
    private AccountAttributeContext accountAttributeContext;

    public AccountContext(TrueDialogClient trueDialogClient,
                          AccountRest.AccountService accountService,
                          AccountAttributeRest.AccountAttributeService accountAttributeService) {
        super(trueDialogClient);
        this.accountService = accountService;
        accountAttributeContext = new AccountAttributeContext(trueDialogClient, accountAttributeService);
    }

    public AccountAttributeContext getAttribute() {
        return accountAttributeContext;
    }

    public Account getById(int accountId) {
        return executeEntityCall(accountService.getAccountById(accountId));
    }

    public Account getById(int accountId, boolean throwIfEmpty) {
        return executeEntityCall(accountService.getAccountById(accountId), throwIfEmpty);
    }

    public Account getCurrentAccount() {
        return getById(trueDialogClient.getCurrentAccount());
    }

    public List<Account> getList() {
        return executeEntityListCall(accountService.getAccountList());
    }

    public List<Account> getList(boolean throwIfEmpty) {
        return executeEntityListCall(accountService.getAccountList(), throwIfEmpty);
    }

    public Account create(Account account) {
        return executeEntityCall(accountService.createAccount(account), true);
    }

    public Account update(Account account) {
        return executeEntityCall(accountService.updateAccount(account.getId(), account), true);
    }

    public void delete(int accountId) {
        executeEntityCall(accountService.deleteAccount(accountId), true);
    }

    public void delete(Account account) {
        delete(account.getId());
    }


}
