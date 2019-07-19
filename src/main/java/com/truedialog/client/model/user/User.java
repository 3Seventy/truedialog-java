package com.truedialog.client.model.user;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {

    /**
     * The login name for the user.
     */
    @JsonProperty("UserName")
    private String userName;

    /**
     * The login password for the user.
     */
    @JsonProperty("Password")
    private String password;

    /**
     * Confirmation password, must match Password.
     */
    @JsonProperty("PasswordConfirmation")
    private String passwordConfirmation;

    /**
     * The account this user is allowed to access.
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * Email address of the user.
     */
    @JsonProperty("Email")
    private String email;

    /**
     * The user's first or given name.
     */
    @JsonProperty("FirstName")
    private String firstName;

    /**
     * The user's last or family name.
     */
    @JsonProperty("LastName")
    private String lastName;


    /**
     * The user's mobile phone number.
     */
    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    /**
     * Gets or sets application-specific information for the membership user.
     */
    @JsonProperty("Comment")
    private String comment;

    /**
     * Whether the membership user can be authenticated.
     * true if the user can be authenticated; otherwise, false.
     */
    @JsonProperty("IsApproved")
    private boolean isApproved;

    /**
     * A value indicating whether the membership user is locked out and unable to be validated.
     * true if the membership user is locked out and unable to be validated; otherwise, false.
     */
    @JsonProperty("IsLockedOut")
    private boolean isLockedOut;

    /**
     * The most recent date and time that the membership user was locked out.
     */
    @JsonProperty("LastLockoutDate")
    private Date lastLockoutDate;

    /**
     * The date and time when the user was added to the membership data store.
     */
    @JsonProperty("CreationDate")
    private Date creationDate;

    /**
     * The date and time when the user was last authenticated.
     */
    @JsonProperty("LastLoginDate")
    private Date lastLoginDate;

    /**
     * The date and time when the membership user was last authenticated or accessed the application.
     */
    @JsonProperty("LastActivityDate")
    private Date lastActivityDate;

    /**
     * The date and time when the membership user's password was last updated.
     */
    @JsonProperty("LastPasswordChangedDate")
    private Date lastPasswordChangedDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean isLockedOut() {
        return isLockedOut;
    }

    public void setLockedOut(boolean lockedOut) {
        isLockedOut = lockedOut;
    }

    public Date getLastLockoutDate() {
        return lastLockoutDate;
    }

    public void setLastLockoutDate(Date lastLockoutDate) {
        this.lastLockoutDate = lastLockoutDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Date getLastPasswordChangedDate() {
        return lastPasswordChangedDate;
    }

    public void setLastPasswordChangedDate(Date lastPasswordChangedDate) {
        this.lastPasswordChangedDate = lastPasswordChangedDate;
    }
}
