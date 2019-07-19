package com.truedialog.client.context.contactlist;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.base.Base;
import com.truedialog.client.model.filter.FilterGroup;
import com.truedialog.client.rest.contactlist.FilterGroupRest;

import java.util.List;

public class FilterGroupContext extends BaseContext {

    private FilterGroupRest.FilterGroupService filterGroupService;

    public FilterGroupContext(TrueDialogClient trueDialogClient, FilterGroupRest.FilterGroupService filterGroupService) {
        super(trueDialogClient);
        this.filterGroupService = filterGroupService;
    }

    public List<FilterGroup> getList(int accountId, int contactListId) {
        return executeEntityListCall(filterGroupService.getFilterGroupList(accountId, contactListId));
    }

    public List<FilterGroup> getList(int accountId, int contactListId, boolean throwIfEmpty) {
        return executeEntityListCall(filterGroupService.getFilterGroupList(accountId, contactListId), throwIfEmpty);
    }

    public List<FilterGroup> getList(int contactListId, boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), contactListId, throwIfEmpty);
    }

    public List<FilterGroup> getList(int contactListId) {
        return getList(trueDialogClient.getCurrentAccount(), contactListId);
    }

    public FilterGroup getById(int accountId, int contactListId, int groupId) {
        return executeEntityCall(filterGroupService.getFilterGroupById(accountId, contactListId, groupId));
    }

    public FilterGroup getById(int contactListId, int groupId) {
        return getById(trueDialogClient.getCurrentAccount(), contactListId, groupId);
    }

    public FilterGroup getById(int accountId, int contactListId, int groupId, boolean throwIfEmpty) {
        return executeEntityCall(filterGroupService.getFilterGroupById(accountId, contactListId, groupId), throwIfEmpty);
    }

    public FilterGroup getById(int contactListId, int groupId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), contactListId, groupId, throwIfEmpty);
    }


}
