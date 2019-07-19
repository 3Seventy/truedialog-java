package com.truedialog.client.model.campaign;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.Base;

import java.util.Date;
import java.util.UUID;

/**
 * Coupon Code assosiated with the External Coupon List
 */
public class ExternalCouponCode extends Base {
    /**
     * Account this code belongs to
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The Customer who received the external coupon code
     */
    @JsonProperty("ContactId")
    private int contactId;

    /**
     * The external coupon code
     */
    @JsonProperty("CouponCode")
    private String couponCode;

    /**
     * The date when the external coupon code is created
     */
    @JsonProperty("Created")
    private Date created;

    /**
     * External Coupon list Id associated with this Coupon Code
     */
    @JsonProperty("ListId")
    private int listId;

    /**
     * Reservation token Identifier for this coupon code
     */
    @JsonProperty("ReservationToken")
    private UUID reservationToken;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public UUID getReservationToken() {
        return reservationToken;
    }

    public void setReservationToken(UUID reservationToken) {
        this.reservationToken = reservationToken;
    }
}