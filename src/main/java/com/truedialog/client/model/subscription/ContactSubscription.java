package com.truedialog.client.model.subscription;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.SubscriptionType;
import com.truedialog.client.model.contact.Contact;

/**
 * Details for a contact's subscription options.
 * <p>
 * <strong>Important Note:</strong> Setting the correct subscription type is important for following correct CTIA
 * compliance guidelines.
 * </p>
 *
 * @see Contact
 * @see Subscription
 * @see SubscriptionType SubscriptionType
 *
 * @author Bryce Simonds
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ContactSubscription
{
    /**
     * The {@link Subscription} ID the contact is a member of.
     *
     * <p>
     * <strong>Important Note:</strong> Setting the correct subscription type is important for following correct CTIA
     * compliance guidelines.
     * </p>
     */
    @JsonProperty("SubscriptionId")
    private int subscriptionId;

    /**
     * Set if the contact wishes to receive SMS messages.
     * <p>
     * Note that according to current CTIA requirements we MUST send a handset verification when a contact is manually
     * opted in to a {@link SubscriptionType#RECURRING RECURRING} {@link Subscription}.
     * </p>
     */
    @JsonProperty("SmsEnabled")
    private boolean smsEnabled;

    /**
     * Set if the contact wishes to receive MMS messages.
     * <p>
     * Not currently used.
     * </p>
     * <p>
     * Note that according to current CTIA requirements we MUST send a handset verification when a contact is manually
     * opted in to a {@link SubscriptionType#RECURRING RECURRING} {@link Subscription}.
     * </p>
     */
    @JsonProperty("MmsEnabled")
    private boolean mmsEnabled;

    /**
     * Set if the contact wishes to receive email messages.
     */
    @JsonProperty("EmailEnabled")
    private boolean emailEnabled;

    /**
     * Set if the contact wishes to receive voice messages.
     * <p>
     * Not currently used.
     * </p>
     */
    @JsonProperty("VoiceEnabled")
    private boolean voiceEnabled;

    /**
     * Gets the {@link Subscription} ID the contact is a member of.
     *
     * <p>
     * <strong>Important Note:</strong> Setting the correct subscription type is important for following correct CTIA
     * compliance guidelines.
     * </p>
     */
    public int getSubscriptionId()
    {
        return subscriptionId;
    }

    /**
     * Sets the {@link Subscription} ID the contact is a member of.
     *
     * <p>
     * <strong>Important Note:</strong> Setting the correct subscription type is important for following correct CTIA
     * compliance guidelines.
     * </p>
     */
    public void setSubscriptionId(int subscriptionId)
    {
        this.subscriptionId = subscriptionId;
    }

    /**
     * Checks to see if the contact wishes to receive SMS messages.
     */
    public boolean isSmsEnabled()
    {
        return smsEnabled;
    }

    /**
     * Set if the contact wishes to receive SMS messages.
     * <p>
     * Note that according to current CTIA requirements we MUST send a handset verification when a contact is manually
     * opted in to a {@link SubscriptionType#RECURRING RECURRING} {@link Subscription}.
     * </p>
     *
     * @param smsEnabled
     *            Set to enable SMS sending, unset to disable SMS sending.
     */
    public void setSmsEnabled(boolean smsEnabled)
    {
        this.smsEnabled = smsEnabled;
    }

    /**
     * Checks to see if the contact wishes to receive MMS messages.
     * <p>
     * Not currently used.
     * </p>
     */
    public boolean isMmsEnabled()
    {
        return mmsEnabled;
    }

    /**
     * Set if the contact wishes to receive MMS messages.
     * <p>
     * Not currently used.
     * </p>
     * <p>
     * Note that according to current CTIA requirements we MUST send a handset verification when a contact is manually
     * opted in to a {@link SubscriptionType#RECURRING RECURRING} {@link Subscription}.
     * </p>
     *
     * @param mmsEnabled
     *            Set to enable MMS sending, unset to disable MMS sending.
     */
    public void setMmsEnabled(boolean mmsEnabled)
    {
        this.mmsEnabled = mmsEnabled;
    }

    /**
     * Checks to see if the contact wishes to receive email messages.
     */
    public boolean isEmailEnabled()
    {
        return emailEnabled;
    }

    /**
     * Sets if the contact wishes to receive email messages.
     *
     * @param emailEnabled
     *            Set to enable email sending, unset to disable email sending.
     */
    public void setEmailEnabled(boolean emailEnabled)
    {
        this.emailEnabled = emailEnabled;
    }

    /**
     * Checks to see if the contact wishes to receive voice messages.
     * <p>
     * Not currently used.
     * </p>
     */
    public boolean isVoiceEnabled()
    {
        return voiceEnabled;
    }

    /**
     * Set if the contact wishes to receive voice messages.
     * <p>
     * Not currently used.
     * </p>
     *
     * @param voiceEnabled
     *            Set to enable voice sending, unset to disable voice sending.
     */
    public void setVoiceEnabled(boolean voiceEnabled)
    {
        this.voiceEnabled = voiceEnabled;
    }
}
