package com.truedialog.client.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.Base;

public class AccountAttribute extends Base {

    /**
     * The ID of the account this attribute is directly set on.
     * <p>
     * Account attributes are inherited, this value can be used to determine which account a value is set on so inheritance and overrides can be easily tracked.
     * </p>
     **/

    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The name of the attribute
     */

    @JsonProperty("name")
    private String name;

    /**
     * The value of the attribute
     */
    @JsonProperty("Value")
    private Object value;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
