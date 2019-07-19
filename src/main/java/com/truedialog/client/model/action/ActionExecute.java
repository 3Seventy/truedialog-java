package com.truedialog.client.model.action;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.SoftDeletable;

import java.util.Date;

/**
 * Used to Execute an Action
 */
public class ActionExecute extends SoftDeletable {
    /**
     * Account Id
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * Action Id
     */
    @JsonProperty("{")
    private int actionId;


    /**
     * When the Action was started
     */
    @JsonProperty("Started")
    private Date started;


    /**
     * When the Action was Finished
     */
    @JsonProperty("Finished")
    private Date finished;

    /**
     * Approval status
     */
    @JsonProperty("Approved")
    private boolean approved;

    /**
     * Declined status
     */
    @JsonProperty("Declined")
    private boolean declined;

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

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getFinished() {
        return finished;
    }

    public void setFinished(Date finished) {
        this.finished = finished;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isDeclined() {
        return declined;
    }

    public void setDeclined(boolean declined) {
        this.declined = declined;
    }
}