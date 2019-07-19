package com.truedialog.client.context.action;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.action.ActionSchedule;
import com.truedialog.client.rest.action.ScheduleRest;

import java.util.List;

public class ScheduleContext extends BaseContext {

    private ScheduleRest.ScheduleService scheduleService;

    public ScheduleContext(TrueDialogClient trueDialogClient, ScheduleRest.ScheduleService scheduleService) {
        super(trueDialogClient);
        this.scheduleService = scheduleService;
    }

    // List
    public List<ActionSchedule> getList(int actionId) {
        return getList(trueDialogClient.getCurrentAccount(), actionId);
    }

    public List<ActionSchedule> getList(int actionId, boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), actionId, throwIfEmpty);
    }

    public List<ActionSchedule> getList(int accountId, int actionId) {
        return executeEntityListCall(scheduleService.getScheduleList(accountId, actionId));
    }

    public List<ActionSchedule> getList(int accountId, int actionId, boolean throwIfEmpty) {
        return executeEntityListCall(scheduleService.getScheduleList(accountId, actionId), throwIfEmpty);
    }

    // By id
    public ActionSchedule getById(int actionId, int scheduleId) {
        return getById(trueDialogClient.getCurrentAccount(), actionId, scheduleId);
    }

    public ActionSchedule getById(int actionId, int scheduleId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), actionId, scheduleId, throwIfEmpty);
    }

    public ActionSchedule getById(int accountId, int actionId, int scheduleId) {
        return executeEntityCall(scheduleService.getSchedule(accountId, actionId, scheduleId));
    }

    public ActionSchedule getById(int accountId, int actionId, int scheduleId, boolean throwIfEmpty) {
        return executeEntityCall(scheduleService.getSchedule(accountId, actionId, scheduleId), throwIfEmpty);
    }

    public ActionSchedule create(int accountId, int actionId, ActionSchedule schedule) {
        return executeEntityCall(scheduleService.createSchedule(accountId, actionId, schedule), true);
    }

    public ActionSchedule create(int actionId, ActionSchedule schedule) {
        int accountId = schedule.getAccountId() > 0 ? schedule.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, actionId, schedule);
    }

    public ActionSchedule create(ActionSchedule schedule) {
        if (schedule.getActionId() == 0)
            throw new IllegalArgumentException("Action ID is missing.");

        int accountId = schedule.getAccountId() > 0 ? schedule.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, schedule.getActionId(), schedule);
    }

    public ActionSchedule update(int accountId, int actionId, int scheduleId, ActionSchedule schedule) {
        return executeEntityCall(scheduleService.updateSchedule(accountId, actionId, scheduleId, schedule), true);
    }

    public ActionSchedule update(int actionId, int scheduleId, ActionSchedule schedule) {
        return update(trueDialogClient.getCurrentAccount(), actionId, scheduleId, schedule);
    }

    public ActionSchedule update(ActionSchedule schedule) {
        if (schedule.getActionId() == 0)
            throw new IllegalArgumentException("Action ID is missing.");
        if (schedule.getId() == 0)
            throw new IllegalArgumentException("Schedule ID is missing.");

        int accountId = schedule.getAccountId() > 0 ? schedule.getAccountId() : trueDialogClient.getCurrentAccount();

        return update(accountId, schedule.getActionId(), schedule.getId(), schedule);
    }

    public void delete(int accountId, int actionId, int scheduleId) {
        executeEntityCall(scheduleService.deleteSchedule(accountId, actionId, scheduleId), true);
    }

    public void delete(int actionId, int scheduleId) {
        delete(trueDialogClient.getCurrentAccount(), actionId, scheduleId);
    }

    public void delete(ActionSchedule schedule) {
        if (schedule.getActionId() == 0)
            throw new IllegalArgumentException("Action ID is missing.");
        if (schedule.getId() == 0)
            throw new IllegalArgumentException("Schedule ID is missing.");

        int accountId = schedule.getAccountId() > 0 ? schedule.getAccountId() : trueDialogClient.getCurrentAccount();

        delete(accountId, schedule.getActionId(), schedule.getId());
    }
}
