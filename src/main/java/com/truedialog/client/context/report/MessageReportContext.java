package com.truedialog.client.context.report;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.report.MessageReportRow;
import com.truedialog.client.rest.report.MessageReportRest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MessageReportContext extends BaseContext {

    private MessageReportRest.MessageReportService messageReportService;

    public MessageReportContext(TrueDialogClient trueDialogClient, MessageReportRest.MessageReportService messageReportService) {
        super(trueDialogClient);
        this.messageReportService = messageReportService;
    }


    public List<MessageReportRow> getMessageReport() {
        return getMessageReport(trueDialogClient.getCurrentAccount(), false);
    }

    public List<MessageReportRow> getMessageReport(boolean throwIfEmpty) {
        return getMessageReport(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<MessageReportRow> getMessageReport(int accountId) {
        return internalGetReport(accountId, null, null, null, false);
    }

    public List<MessageReportRow> getMessageReport(int accountId, boolean throwIfEmpty) {
        return internalGetReport(accountId, null, null, null, throwIfEmpty);
    }

    public List<MessageReportRow> getMessageReportFrame(int accountId, Date from, Date to) {
        return internalGetReport(accountId, from, to, null, false);
    }

    public List<MessageReportRow> getMessageReportFrame(int accountId, Date from, Date to, boolean throwIfEmpty) {
        return internalGetReport(accountId, from, to, null, throwIfEmpty);
    }

    public List<MessageReportRow> getMessageReportFrame(Date from, Date to) {
        return getMessageReportFrame(trueDialogClient.getCurrentAccount(), from, to);
    }

    public List<MessageReportRow> getMessageReportFrame(Date from, Date to, boolean throwIfEmpty) {
        return getMessageReportFrame(trueDialogClient.getCurrentAccount(), from, to, throwIfEmpty);
    }

    public List<MessageReportRow> getMessageReportForAction(int accountId, int actionId) {
        return internalGetReport(accountId, null, null, String.format("$filter=ActionId eq %d", actionId), false);
    }

    public List<MessageReportRow> getMessageReportForAction(int accountId, int actionId, boolean throwIfEmpty) {
        return internalGetReport(accountId, null, null, String.format("$filter=ActionId eq %d", actionId), throwIfEmpty);
    }

    public List<MessageReportRow> getMessageReportForAction(int actionId) {
        return getMessageReportForAction(trueDialogClient.getCurrentAccount(), actionId);
    }

    public List<MessageReportRow> getMessageReportForAction(int actionId, boolean throwIfEmpty) {
        return getMessageReportForAction(trueDialogClient.getCurrentAccount(), actionId, throwIfEmpty);
    }

    public List<MessageReportRow> getMessageReportAdvanced(int accountId, Date from, Date to, String filter, boolean throwIfEmpty) {
        return internalGetReport(accountId, from, to, filter, throwIfEmpty);
    }

    public List<MessageReportRow> getMessageReportAdvanced(int accountId, Date from, Date to, String filter) {
        return internalGetReport(accountId, from, to, filter, false);
    }

    public List<MessageReportRow> getMessageReportAdvanced(Date from, Date to, String filter) {
        return internalGetReport(trueDialogClient.getCurrentAccount(), from, to, filter, false);
    }

    public List<MessageReportRow> getMessageReportAdvanced(Date from, Date to, String filter, boolean throwIfEmpty) {
        return internalGetReport(trueDialogClient.getCurrentAccount(), from, to, filter, throwIfEmpty);
    }

    private List<MessageReportRow> internalGetReport(int accountId, Date from, Date to, String filter, boolean throwIfEmpty) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return executeEntityListCall(messageReportService.getMessageReportRawList(accountId, from == null ? null : format.format(from), to == null ? null : format.format(to), filter), throwIfEmpty);
    }
}
