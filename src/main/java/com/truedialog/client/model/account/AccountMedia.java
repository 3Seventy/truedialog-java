package com.truedialog.client.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.Base;

public class AccountMedia extends Base {

    @JsonProperty("AccountId")
    private int accountId;
    @JsonProperty("Uri")
    private String uri;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
