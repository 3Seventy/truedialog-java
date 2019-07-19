package com.truedialog.client.model.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.ResourceStatus;
import com.truedialog.client.model.base.Base;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class Account extends Base
{
    /**
     * The current status of the account.
     *
     * This is the soft delete status.
     */
    // TODO: Remove this in the future.
    @JsonProperty("Status")
    private Integer statusId;

    /**
     * The parent account which owns this account.
     * <p>
     * This will be {@code null} for the root account.
     * </p>
     */
    @JsonProperty("ParentId")
    private Integer parentId;

    /**
     * The name of the account.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The date/time the account was created.
     */
    @JsonProperty("Created")
    private Date created;

    /**
     * Set if the account is allowed to make callbacks.
     */
    @JsonProperty("AllowCallback")
    private boolean allowCallback;

    /**
     * The token that is used when making callbacks.
     * <p>
     * When 3Seventy makes a callback this token will be sent along with that callback request.
     * </p>
     * <p>
     * This token can be whatever GUID of your choosing.
     * </p>
     */
    @JsonProperty("CallbackToken")
    private String callbackToken;

    /**
     * Gets the current status ID of the account.
     */
    public Integer getStatusId()
    {
        return statusId;
    }

    /**
     * Gets the current status of the account.
     */
    public ResourceStatus getStatus()
    {
        return ResourceStatus.resourceStatus(statusId);
    }

    /**
     * Gets the ID of the parent account which owns this account.
     * <p>
     * This will be {@code null} for the root account.
     * </p>
     */
    public Integer getParentId()
    {
        return parentId;
    }

    /**
     * Sets the parent ID of this account to the parent account which will own it.
     * <p>
     * This value cannot be set to {@code null} for new accounts.
     * </p>
     *
     * @param parentId
     *            The parent account ID to use.
     */
    public void setParentId(int parentId)
    {
        this.parentId = parentId;
    }

    /**
     * Gets a descriptive name for the account.
     * <p>
     * Account names are used for giving a descriptive label to the account, and are not used directly by the system.
     * </p>
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets a descriptive name for the account.
     * <p>
     * Account names are used for giving a descriptive label to the account, and are not used directly by the system.
     * </p>
     *
     * @param name
     *            The new name of the account.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the date/time the account was created.
     */
    public Date getCreated()
    {
        return created;
    }

    /**
     * Gets if callbacks are enabled on this account or not.
     */
    public boolean getAllowCallback()
    {
        return allowCallback;
    }

    /**
     * Enables or disables callbacks on this account.
     *
     * @param allowCallback
     *            The new value for AllowCallback
     */
    public void setAllowCallback(boolean allowCallback)
    {
        this.allowCallback = allowCallback;
    }

    /**
     * The token that is used when making callbacks.
     * <p>
     * When 3Seventy makes a callback this token will be sent along with that callback request.
     * </p>
     * <p>
     * This token can be whatever GUID of your choosing.
     * </p>
     */
    public String getCallbackToken()
    {
        return callbackToken;
    }

    /**
     * Sets the callback token that is used when making callbacks.
     * <p>
     * When 3Seventy makes a callback this token will be sent along with that callback request.
     * </p>
     * <p>
     * This token can be whatever GUID of your choosing.
     * </p>
     *
     * @param callbackToken
     *            The new callback token to send on callbacks.
     */
    public void setCallbackToken(String callbackToken)
    {
        this.callbackToken = callbackToken;
    }
}
