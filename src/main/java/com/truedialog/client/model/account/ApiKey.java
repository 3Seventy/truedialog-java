package com.truedialog.client.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.ApiKeyType;
import com.truedialog.client.model.base.Base;

import java.util.Date;

/**
 * Api Key details
 */
public class ApiKey extends Base    {
    /**
    * User defined identificator
    */@JsonProperty("Label")
    private String label;

    /**
    * Api Key (used as username for login)
    */@JsonProperty("Key")
    private String key;

    /**
    * A secret. Used as a login password.
    */@JsonProperty("Secret")
    private String secret;

    /**
    * Type of a key
    */
    @JsonProperty("TypeId")
    private int typeId;

    /**
    * Api key type mapping
    */
    private ApiKeyType type;

    /**
    * Optional. A date and time this key is valid to.
    * Applicable to Temporary keys only.
    */
    @JsonProperty("ValidTo")
    private Date validTo;

    /**
    * A date and time this key was last used.
    */
    @JsonProperty("LastActivity")
    private Date lastActivity;

    /**
    * An account id this key has direct access to.
    */
    @JsonProperty("AccountId")
    private int accountId;

    /**
    * Username this key belongs to.
    * Applicable to Master keys only.
    */@JsonProperty("UserName")
    private String userName;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public ApiKeyType getType() {
        return ApiKeyType.apiKeyType(typeId);
    }

    public void setType(ApiKeyType type) {
        this.typeId = type.getValue();
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}