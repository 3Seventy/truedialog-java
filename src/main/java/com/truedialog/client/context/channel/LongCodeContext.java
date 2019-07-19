package com.truedialog.client.context.channel;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.channel.LongCode;
import com.truedialog.client.rest.channel.LongCodeRest;
import com.truedialog.client.util.Utils;

import java.util.List;

public class LongCodeContext extends BaseContext {

    private LongCodeRest.LongCodeService longCodeService;

    public LongCodeContext(TrueDialogClient trueDialogClient, LongCodeRest.LongCodeService longCodeService) {
        super(trueDialogClient);
        this.longCodeService = longCodeService;
    }

    public List<String> getRawList() {
        return getRawList(trueDialogClient.getCurrentAccount());
    }

    public List<String> getRawList(boolean throwIfEmpty) {
        return getRawList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<String> getRawList(int accountId) {
        return executeEntityListCall(longCodeService.getRawList(accountId));
    }

    public List<String> getRawList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(longCodeService.getRawList(accountId), throwIfEmpty);
    }

    public List<LongCode> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<LongCode> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<LongCode> getList(int accountId) {
        return executeEntityListCall(longCodeService.getLongCodeList(accountId));
    }

    public List<LongCode> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(longCodeService.getLongCodeList(accountId), throwIfEmpty);
    }

    public LongCode addForwarding(int accountId, String longCode, String forwardingNumber) {
        return executeEntityCall(longCodeService.addForwarding(accountId, Utils.softReadPhoneNumber(longCode), Utils.readPhoneNumber(forwardingNumber)), true);
    }

    public LongCode addForwarding(String longCode, String forwardingNumber) {
        return addForwarding(trueDialogClient.getCurrentAccount(), longCode, forwardingNumber);
    }

    public LongCode addForwarding(LongCode longCode, String forwardingNumber) {
        if (longCode.getCode() == null || longCode.getCode().isEmpty())
            throw new IllegalArgumentException("Long code number is missing.");

        return addForwarding(longCode.getCode(), forwardingNumber);
    }

    public LongCode UpdateForwarding(int accountId, String longCode, String forwardingNumber) {
        return addForwarding(accountId, longCode, forwardingNumber);
    }

    public LongCode UpdateForwarding(String longCode, String forwardingNumber) {
        return addForwarding(trueDialogClient.getCurrentAccount(), longCode, forwardingNumber);
    }

    public LongCode UpdateForwarding(LongCode longCode, String forwardingNumber) {
        if (longCode.getCode() == null || longCode.getCode().isEmpty())
            throw new IllegalArgumentException("Long code number is missing.");

        return addForwarding(longCode.getCode(), forwardingNumber);
    }

    public LongCode RemoveForwarding(int accountId, String longCode) {
        return executeEntityCall(longCodeService.removeForwarding(accountId, Utils.softReadPhoneNumber(longCode)), true);
    }

    public LongCode RemoveForwarding(String longCode) {
        return RemoveForwarding(trueDialogClient.getCurrentAccount(), longCode);
    }

    public LongCode RemoveForwarding(LongCode longCode) {
        if (longCode.getCode() == null || longCode.getCode().isEmpty())
            throw new IllegalArgumentException("Long code number is missing.");

        int accountId = longCode.getAccountId() > 0 ? longCode.getAccountId() : trueDialogClient.getCurrentAccount();

        return RemoveForwarding(accountId, longCode.getCode());
    }

    public LongCode VerifyForwarding(int accountId, String longCode, String verificationCode) {
        return executeEntityCall(longCodeService.verifyForwarding(accountId, Utils.softReadPhoneNumber(longCode), verificationCode), true);
    }

    public LongCode VerifyForwarding(String longCode, String verificationCode) {
        return VerifyForwarding(trueDialogClient.getCurrentAccount(), longCode, verificationCode);
    }

    public LongCode VerifyForwarding(LongCode longCode, String verificationCode) {
        if (longCode.getCode() == null || longCode.getCode().isEmpty())
            throw new IllegalArgumentException("Long code number is missing.");

        int accountId = longCode.getAccountId() > 0 ? longCode.getAccountId() : trueDialogClient.getCurrentAccount();

        return VerifyForwarding(accountId, longCode.getCode(), verificationCode);
    }
}
