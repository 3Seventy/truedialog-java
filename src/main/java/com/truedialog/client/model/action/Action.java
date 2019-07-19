package com.truedialog.client.model.action;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.ActionType;
import com.truedialog.client.model.base.SoftDeletable;

/**
 * Used to Create or Get an Action
 */
public class Action extends SoftDeletable {
    /**
     * Action Type Id
     */
    @JsonProperty("TypeId")
    private int typeId;

    /**
     * Account Id
     */
    @JsonProperty("AccountId")
    private int accountId;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * Action Type
     */
    public ActionType getActionType() {
        return ActionType.actionType(typeId);
    }

    public void setActionType(ActionType actionType) {
        this.typeId = actionType.getValue();
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}