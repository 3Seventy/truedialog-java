package com.truedialog.client.context.campaign;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.campaign.ExternalCouponCode;
import com.truedialog.client.model.campaign.ExternalCouponList;
import com.truedialog.client.rest.campaign.ExternalCouponListRest;

import java.util.List;

public class ExternalCouponListContext extends BaseContext {

    private ExternalCouponListRest.ExternalCouponListService externalCouponListService;

    public ExternalCouponListContext(TrueDialogClient trueDialogClient, ExternalCouponListRest.ExternalCouponListService externalCouponListService) {
        super(trueDialogClient);
        this.externalCouponListService = externalCouponListService;
    }

    public List<ExternalCouponList> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<ExternalCouponList> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<ExternalCouponList> getList(int accountId) {
        return executeEntityListCall(externalCouponListService.getExternalCouponList(accountId));
    }

    public List<ExternalCouponList> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(externalCouponListService.getExternalCouponList(accountId), throwIfEmpty);
    }

    public ExternalCouponList getById(int listId) {
        return getById(trueDialogClient.getCurrentAccount(), listId);
    }

    public ExternalCouponList getById(int listId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), listId, throwIfEmpty);
    }

    public ExternalCouponList getById(int accountId, int listId) {
        return executeEntityCall(externalCouponListService.getExternalCoupon(accountId, listId));
    }

    public ExternalCouponList getById(int accountId, int listId, boolean throwIfEmpty) {
        return executeEntityCall(externalCouponListService.getExternalCoupon(accountId, listId), throwIfEmpty);
    }

    public ExternalCouponList create(int accountId, ExternalCouponList list) {
        return executeEntityCall(externalCouponListService.createExternalCoupon(accountId, list), true);
    }

    public ExternalCouponList create(ExternalCouponList list) {
        int accountId = list.getAccountId() > 0 ? list.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, list);
    }

    public ExternalCouponList update(int accountId, int listId, ExternalCouponList list) {
        return executeEntityCall(externalCouponListService.updateExternalCoupon(accountId, listId, list), true);
    }

    public ExternalCouponList update(int listId, ExternalCouponList list) {
        int accountId = list.getAccountId() > 0 ? list.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, listId, list);
    }

    public ExternalCouponList update(ExternalCouponList list) {
        if (list.getId() == 0)
            throw new IllegalArgumentException("List ID is missing.");

        int accountId = list.getAccountId() > 0 ? list.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, list.getId(), list);
    }

    public void delete(int accountId, int listId) {
        executeEntityCall(externalCouponListService.deleteExternalCoupon(accountId, listId), true);
    }

    public void delete(int listId) {
        delete(trueDialogClient.getCurrentAccount(), listId);
    }

    public void delete(ExternalCouponList list) {
        if (list.getId() == 0)
            throw new IllegalArgumentException("List ID is missing.");

        int accountId = list.getAccountId() > 0 ? list.getAccountId() : trueDialogClient.getCurrentAccount();
        delete(accountId, list.getId());
    }

    public List<ExternalCouponCode> getCodes(int listId) {
        return getCodes(trueDialogClient.getCurrentAccount(), listId);
    }

    public List<ExternalCouponCode> getCodes(int listId, boolean throwIfEmpty) {
        return getCodes(trueDialogClient.getCurrentAccount(), listId, throwIfEmpty);
    }

    public List<ExternalCouponCode> getCodes(int accountId, int listId) {
        return executeEntityCall(externalCouponListService.getExternalCouponCodeList(accountId, listId));
    }

    public List<ExternalCouponCode> getCodes(int accountId, int listId, boolean throwIfEmpty) {
        return executeEntityCall(externalCouponListService.getExternalCouponCodeList(accountId, listId), throwIfEmpty);
    }

    public List<ExternalCouponCode> getCodes(ExternalCouponList list) {
        if (list.getId() == 0)
            throw new IllegalArgumentException("List ID is missing.");

        int accountId = list.getAccountId() > 0 ? list.getAccountId() : trueDialogClient.getCurrentAccount();
        return getCodes(accountId, list.getId());
    }

    public List<ExternalCouponCode> getCodes(ExternalCouponList list, boolean throwIfEmpty) {
        if (list.getId() == 0)
            throw new IllegalArgumentException("List ID is missing.");

        int accountId = list.getAccountId() > 0 ? list.getAccountId() : trueDialogClient.getCurrentAccount();
        return getCodes(accountId, list.getId(), throwIfEmpty);
    }
}
