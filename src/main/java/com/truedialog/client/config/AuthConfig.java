package com.truedialog.client.config;

/**
 * Details on how we should connect to the remote service.
 */
public class AuthConfig {

    /**
     * The user name to use when generating the HTTP auth header.
     */
    private String userName;

    /**
     * The password to send through the HTTP auth header.
     */
    private String password;

    /**
     * Default account ID
     */
    private String accountId;

    public AuthConfig(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
