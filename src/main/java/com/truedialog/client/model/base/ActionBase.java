package com.truedialog.client.model.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.action.ActionSchedule;

import java.util.ArrayList;
import java.util.List;

public class ActionBase {

    public ActionBase() {
        schedules = new ArrayList<>();
    }

    /**
     * The account ID that the action reports under.
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The list of schedules associated with the action
     */
    @JsonProperty("Schedules")
    private List<ActionSchedule> schedules;

    /**
     * Set true if the action should be executed on creation
     */
    @JsonProperty("Execute")
    private boolean Execute;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<ActionSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ActionSchedule> schedules) {
        this.schedules = schedules;
    }

    public boolean isExecute() {
        return Execute;
    }

    public void setExecute(boolean execute) {
        Execute = execute;
    }
}
