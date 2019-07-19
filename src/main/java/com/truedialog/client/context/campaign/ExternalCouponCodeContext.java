package com.truedialog.client.context.campaign;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.campaign.ExternalCouponCode;
import com.truedialog.client.model.campaign.ExternalCouponList;
import com.truedialog.client.rest.campaign.ExternalCouponCodeRest;

import java.util.List;

public class ExternalCouponCodeContext extends BaseContext {

    private ExternalCouponCodeRest.ExternalCouponCodeService externalCouponCodeService;

    public ExternalCouponCodeContext(TrueDialogClient trueDialogClient, ExternalCouponCodeRest.ExternalCouponCodeService externalCouponCodeService) {
        super(trueDialogClient);
        this.externalCouponCodeService = externalCouponCodeService;
    }

    public List<ExternalCouponCode> getList(int listId) {
        return getList(trueDialogClient.getCurrentAccount(), listId);
    }

    public List<ExternalCouponCode> getList(int listId, boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), listId, throwIfEmpty);
    }

    public List<ExternalCouponCode> getList(int accountId, int listId) {
        return executeEntityListCall(externalCouponCodeService.getExternalCouponCodeList(accountId, listId), false);
    }

    public List<ExternalCouponCode> getList(int accountId, int listId, boolean throwIfEmpty) {
        return executeEntityListCall(externalCouponCodeService.getExternalCouponCodeList(accountId, listId), throwIfEmpty);
    }

    public List<ExternalCouponCode> getList(ExternalCouponList list) {
        return getList(list, false);
    }

    public List<ExternalCouponCode> getList(ExternalCouponList list, boolean throwIfEmpty) {
        if (list.getId() == 0)
            throw new IllegalArgumentException("List ID is missing.");

        int accountId = list.getAccountId() > 0 ? list.getAccountId() : trueDialogClient.getCurrentAccount();
        return getList(accountId, list.getId(), throwIfEmpty);
    }

    public ExternalCouponCode getById(int listId, String couponCode) {
        return getById(trueDialogClient.getCurrentAccount(), listId, couponCode, false);
    }

    public ExternalCouponCode getById(int listId, String couponCode, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), listId, couponCode, throwIfEmpty);
    }

    public ExternalCouponCode getById(int accountId, int listId, String couponCode) {
        return executeEntityCall(externalCouponCodeService.getExternalCouponCode(accountId, listId, couponCode), false);
    }

    public ExternalCouponCode getById(int accountId, int listId, String couponCode, boolean throwIfEmpty) {
        return executeEntityCall(externalCouponCodeService.getExternalCouponCode(accountId, listId, couponCode), throwIfEmpty);
    }

    public void delete(int accountId, int listId, String couponCode) {
        executeEntityCall(externalCouponCodeService.deleteExternalCouponCode(accountId, listId, couponCode), true);
    }

    public void delete(int listId, String couponCode) {
        delete(trueDialogClient.getCurrentAccount(), listId, couponCode);
    }
}
