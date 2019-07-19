package com.truedialog.client.model.callback;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.CallbackType;
import com.truedialog.client.model.account.Account;
import com.truedialog.client.model.base.Base;

/**
 * Details of a callback the Vector servers will make when an event occurs.
 * <p>
 * Callbacks provide a way to greatly customize the behavior of a campaign.
 * </p>
 * <p>
 * For example, you could attach a keyword to a gateway campaign and then respond to the keyword callback to define your
 * own campaign logic.
 * </p>
 *
 * @author Bryce Simonds
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class Callback extends Base
{
    /**
     * The account to which this callback will occur.
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The type of event which will trigger the callback.
     * <p>
     * Different callback types will send different sets of data.
     * </p>
     */
    @JsonProperty("CallbackType")
    private int callbackTypeId;

    /**
     * The URL that will be called when the callback type event occurs.
     */
    @JsonProperty("Url")
    private String url;

    /**
     * Set if the callback is currently active.
     * <p>
     * This flag allows you to quickly turn a callback on and off.
     * </p>
     */
    @JsonProperty("Active")
    private boolean isActive;

    /**
     * Gets the account to which this callback will occur.
     *
     * @see Account
     */
    public int getAccountId()
    {
        return accountId;
    }

    /**
     * Sets the account to which this callback will occur.
     *
     * @param accountId
     *            The new account ID to set.
     *
     * @see Account
     */
    public void setAccountId(int accountId)
    {
        this.accountId = accountId;
    }

    /**
     * Gets the URL that will be called when the callback type event occurs.
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Sets the URL that will be called when the callback type event occurs.
     *
     * @param url
     *            The new URL which the callback will be sent to.
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Gets if the callback is active or not.
     */
    public boolean isActive()
    {
        return isActive;
    }

    /**
     * Sets if the callback is active or not.
     *
     * @param active
     *            Set to enable the callback, unset to disable it.
     */
    public void setActive(boolean active)
    {
        isActive = active;
    }

    /**
     * Gets the type of callback that is being made
     *
     * @see Callback#getCallbackType() getCallbackType()
     * @see CallbackType
     */
    public int getCallbackTypeId()
    {
        return callbackTypeId;
    }

    /**
     * Sets the type of callback that will be made.
     *
     * @param callbackTypeId
     *            The new type for the callback.
     *
     * @see Callback#setCallbackType(CallbackType) setCallbackType(CallbackType)
     * @see CallbackType
     */
    public void setCallbackTypeId(int callbackTypeId)
    {
        this.callbackTypeId = callbackTypeId;
    }

    /**
     * Gets the type of callback that is being made.
     * <p>
     * This is an enumeration alias for {@link Callback#getCallbackTypeId() getCallbackTypeId()}
     * </p>
     *
     * @see CallbackType
     */
    public CallbackType getCallbackType()
    {
        return CallbackType.getCallbackType(callbackTypeId);
    }

    /**
     * Sets the type of callback that will be made.
     * <p>
     * This is an enumeration alias for {@link Callback#setCallbackTypeId(int) setCallbackTypeId(int)}
     * </p>
     *
     * @param callbackType
     *            The new type for the callback.
     *
     * @see CallbackType
     */
    public void setCallbackType(CallbackType callbackType)
    {
        callbackTypeId = callbackType.getValue();
    }
}