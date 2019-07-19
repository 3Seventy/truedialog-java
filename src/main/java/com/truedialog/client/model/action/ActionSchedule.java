package com.truedialog.client.model.action;

/// <summary>
/// Used to Schedule an Action
/// </summary>

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.ScheduleType;
import com.truedialog.client.model.base.BaseAudited;

import java.util.Date;

public class ActionSchedule extends BaseAudited {
    /**
     * Account Id
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * Action Id
     */
    @JsonProperty("ActionId")
    private int actionId;


    /**
     * Schedule Type Id
     */
    @JsonProperty("ScheduleTypeId")
    private int scheduleTypeId;

    /**
     * Schedule Type Enum
     */
    @JsonIgnore
    private ScheduleType scheduleType;

    public ScheduleType getScheduleType() {
        return ScheduleType.scheduleType(scheduleTypeId);
    }

    public void setScheduleType(ScheduleType type) {
        scheduleTypeId = type.getValue();
    }

    /**
     * Time of day to start run at Ex: 12:20:00 or 17:04:40
     */
    @JsonProperty("RunAt")
    private String RunAt;

    /**
     * Date and time from which schedule will start.
     */
    @JsonProperty("StartFrom")
    private Date StartFrom;

    /**
     * Day(s) of week to run action on.
     */
    @JsonProperty("WeekDay")
    private String WeekDay;


    /**
     * Day(s) of month to run action on.
     */
    @JsonProperty("MonthDay")
    private String MonthDay;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public int getScheduleTypeId() {
        return scheduleTypeId;
    }

    public void setScheduleTypeId(int scheduleTypeId) {
        this.scheduleTypeId = scheduleTypeId;
    }

    public String getRunAt() {
        return RunAt;
    }

    public void setRunAt(String runAt) {
        RunAt = runAt;
    }

    public Date getStartFrom() {
        return StartFrom;
    }

    public void setStartFrom(Date startFrom) {
        StartFrom = startFrom;
    }

    public String getWeekDay() {
        return WeekDay;
    }

    public void setWeekDay(String weekDay) {
        WeekDay = weekDay;
    }

    public String getMonthDay() {
        return MonthDay;
    }

    public void setMonthDay(String monthDay) {
        MonthDay = monthDay;
    }
}