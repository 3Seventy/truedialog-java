package com.truedialog.client.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Used for updating a user's password.
 */
public class UserPassword {

    /**
     * The account the user falls under.
     */
    @JsonProperty("AccoundId")
    private int accountId;

    /**
     * User name.
     */
    @JsonProperty("UserName")
    private String userName;

    /**
     * The new login password for the user.
     */
    @JsonProperty("NewPassword")
    private String newPassword;

    /**
     * Confirmation password.  Must match NewPassword.
     */
    @JsonProperty("ConfirmPassword")
    private String confirmPassword;

}
