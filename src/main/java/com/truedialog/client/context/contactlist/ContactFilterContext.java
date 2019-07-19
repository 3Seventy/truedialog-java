package com.truedialog.client.context.contactlist;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.filter.ContactFilter;
import com.truedialog.client.rest.contactlist.ContactFilterRest;

import java.util.List;


public class ContactFilterContext extends BaseContext {
    private ContactFilterRest.ContactFilterService contactFilterService;

    public ContactFilterContext(TrueDialogClient trueDialogClient, ContactFilterRest.ContactFilterService contactFilterService) {
        super(trueDialogClient);
        this.contactFilterService = contactFilterService;
    }

    //getList
    public List<ContactFilter> getList(int accountId, int contactListId, int groupId) {
        return executeEntityListCall(contactFilterService.getContactFilterList(accountId, contactListId, groupId));
    }

    public List<ContactFilter> getList(int contactListId, int groupId) {
        return getList(trueDialogClient.getCurrentAccount(), contactListId, groupId);
    }

    public List<ContactFilter> getList(int contactListId, int groupId, boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), contactListId, groupId, throwIfEmpty);
    }

    public List<ContactFilter> getList(int accountId, int contactListId, int groupId, boolean throwIfEmpty) {
        return executeEntityListCall(contactFilterService.getContactFilterList(accountId, contactListId, groupId), throwIfEmpty);
    }

    //getById

    public ContactFilter getById(int accountId, int contactListId, int groupId, int filterId) {
        return executeEntityCall(contactFilterService.getContactFilterById(accountId, contactListId, groupId, filterId));
    }

    public ContactFilter getById(int contactListId, int groupId, int filterId) {
        return getById(trueDialogClient.getCurrentAccount(), contactListId, groupId, filterId);
    }

    public ContactFilter getById(int contactListId, int groupId, int filterId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), contactListId, groupId, filterId, throwIfEmpty);
    }

    public ContactFilter getById(int accountId, int contactListId, int groupId, int filterId, boolean throwIfEmpty) {
        return executeEntityCall(contactFilterService.getContactFilterById(accountId, contactListId, groupId, filterId), throwIfEmpty);
    }

    public ContactFilter update(int accountId, int contactListId, int groupId, int filterId, ContactFilter filter) {
        return executeEntityCall(contactFilterService.updateContactFilter(accountId, contactListId, groupId, filter));
    }

    public ContactFilter update(int contactListId, ContactFilter filter) {
        if (filter.getId() == 0) {
            throw new IllegalArgumentException("Filter ID is missing.");
        }
        if (filter.getGroupId() == 0) {
            throw new IllegalArgumentException("Filter group ID is missing.");
        }

        int accountId = filter.getAccountId() > 0 ? filter.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, contactListId, filter.getGroupId(), filter.getId(), filter);
    }
}
