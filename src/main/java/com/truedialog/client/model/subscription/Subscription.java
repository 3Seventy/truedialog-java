package com.truedialog.client.model.subscription;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.SubscriptionType;
import com.truedialog.client.model.base.SoftDeletable;

/**
 * Represents a subscription that a contact can opt into and out of.
 * <p>
 * Subscriptions provide your contacts a way to select what types messages they wish to, or not to, receive. It also
 * allows them to specify how they wish to receive these messages.
 * </p>
 * <p>
 * <strong>Important Note:</strong> Setting the correct subscription type is important for following correct CTIA
 * compliance guidelines.
 * </p>
 *
 * @see ContactSubscription
 * @see SubscriptionType
 *
 * @author Bryce Simonds
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class Subscription extends SoftDeletable
{
    @JsonProperty("AccountId")
    private int accountId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("Label")
    private String label;

    @JsonProperty("SubscriptionTypeId")
    private int subscriptionTypeId;

    @JsonProperty("Frequency")
    private int frequency;

    /**
     * Constructor
     */
    public Subscription()
    {
        frequency = 30; // Default to 30 messages a month.
    }

    /**
     * Gets the account ID which owns this subscription object.
     */
    public int getAccountId()
    {
        return accountId;
    }

    /**
     * Sets the account ID which owns this subscription object.
     *
     * @param accountId
     *            The new account ID.
     */
    public void setAccountId(int accountId)
    {
        this.accountId = accountId;
    }

    /**
     * Gets the name of this subscription.
     *
     * <p>
     * This is the name that is used when asking contacts to select a subscription to opt out of (in the case where they
     * are opted into more than one subscription)
     * </p>
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this subscription.
     *
     * <p>
     * This is the name that is used when asking contacts to select a subscription to opt out of (in the case where they
     * are opted into more than one subscription)
     * </p>
     *
     * @param name
     *            The new name for the subscription.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the pretty display name for the subscription.
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Sets the pretty display name for the subscription.
     *
     * @param label
     *            The new label for the susbscription.
     */
    public void setLabel(String label)
    {
        this.label = label;
    }

    /**
     *
     * Gets the type ID of subscription, either one-time or recurring.
     *
     * <p>
     * {@link SubscriptionType#RECURRING RECURRING} subscriptions are for situations where multiple messages are going
     * to be sent to a contact on an ongoing basis. Most types of subscriptions will fall into this category. A good
     * example is for a marketing campaign where events and coupons might be sent out to a list of interested customers.
     * </p>
     * <p>
     * {@link SubscriptionType#ONE_TIME ONE_TIME} subscriptions are for one off messages where the intention is to send
     * a single message to that customer once. A good example would be to notify specific people they have a package
     * waiting in an office, or that their scheduled service call will be arriving shortly.
     * </p>
     *
     * @return the subscription type id
     *
     * @see Subscription#getSubscriptionType() getSubscriptionType()
     * @see SubscriptionType
     */
    public int getSubscriptionTypeId()
    {
        return subscriptionTypeId;
    }

    /**
     * Sets the type ID of subscription, either one-time or recurring.
     *
     * <p>
     * {@link SubscriptionType#RECURRING RECURRING} subscriptions are for situations where multiple messages are going
     * to be sent to a contact on an ongoing basis. Most types of subscriptions will fall into this category. A good
     * example is for a marketing campaign where events and coupons might be sent out to a list of interested customers.
     * </p>
     * <p>
     * {@link SubscriptionType#ONE_TIME ONE_TIME} subscriptions are for one off messages where the intention is to send
     * a single message to that customer once. A good example would be to notify specific people they have a package
     * waiting in an office, or that their scheduled service call will be arriving shortly.
     * </p>
     *
     * @param subscriptionTypeId
     *            The new subscription type id
     *
     * @see Subscription#setSubscriptionType(SubscriptionType) setSubscriptionType(SubscriptionType)
     * @see SubscriptionType
     */
    public void setSubscriptionTypeId(int subscriptionTypeId)
    {
        this.subscriptionTypeId = subscriptionTypeId;
    }

    /**
     * Gets the number of messages (on average) per month a contact can expect to get on this subscription.
     *
     * <p>
     * This value is only relevant to {@link SubscriptionType#RECURRING RECURRING} subscriptions. It is ignored for
     * {@link SubscriptionType#ONE_TIME ONE_TIME} subscriptions. The default is 30 messages per month.
     * </p>
     *
     * @return the frequency
     *
     * @see SubscriptionType
     */
    public int getFrequency()
    {
        return frequency;
    }

    /**
     * Sets the number of messages (on average) per month a contact can expect to get on this subscription.
     *
     * <p>
     * This value is only relevant to {@link SubscriptionType#RECURRING RECURRING} subscriptions. It is ignored for
     * {@link SubscriptionType#ONE_TIME ONE_TIME} subscriptions. The default is 30 messages per month.
     * </p>
     *
     * @param frequency
     *            The new message frequency.
     *
     * @see SubscriptionType
     */
    public void setFrequency(int frequency)
    {
        this.frequency = frequency;
    }

    /**
     * Gets the type of subscription, either one-time or recurring.
     *
     * <p>
     * {@link SubscriptionType#RECURRING RECURRING} subscriptions are for situations where multiple messages are going
     * to be sent to a contact on an ongoing basis. Most types of subscriptions will fall into this category. A good
     * example is for a marketing campaign where events and coupons might be sent out to a list of interested customers.
     * </p>
     * <p>
     * {@link SubscriptionType#ONE_TIME ONE_TIME} subscriptions are for one off messages where the intention is to send
     * a single message to that customer once. A good example would be to notify specific people they have a package
     * waiting in an office, or that their scheduled service call will be arriving shortly.
     * </p>
     * <p>
     * This is an enumeration alias for {@link Subscription#getSubscriptionTypeId() getSubscriptionTypeId()}.
     * </p>
     *
     * @see SubscriptionType
     */
    public SubscriptionType getSubscriptionType()
    {
        return SubscriptionType.subscriptionType(subscriptionTypeId);
    }

    /**
     * Sets the type of subscription, either one-time or recurring.
     *
     * <p>
     * {@link SubscriptionType#RECURRING RECURRING} subscriptions are for situations where multiple messages are going
     * to be sent to a contact on an ongoing basis. Most types of subscriptions will fall into this category. A good
     * example is for a marketing campaign where events and coupons might be sent out to a list of interested customers.
     * </p>
     * <p>
     * {@link SubscriptionType#ONE_TIME ONE_TIME} subscriptions are for one off messages where the intention is to send
     * a single message to that customer once. A good example would be to notify specific people they have a package
     * waiting in an office, or that their scheduled service call will be arriving shortly.
     * </p>
     * <p>
     * This is an enumeration alias for {@link Subscription#setSubscriptionTypeId(int) setSubscriptionTypeId(int)}.
     * </p>
     *
     * @param subscriptionType
     *            The new subscription type
     *
     * @see SubscriptionType
     */
    public void setSubscriptionType(SubscriptionType subscriptionType)
    {
        subscriptionTypeId = subscriptionType.getValue();
    }
}
