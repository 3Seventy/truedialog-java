package com.truedialog.client.model.filter;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.BaseAudited;

/**
 * Contact list details
 */
public class ContactList extends BaseAudited{

    /**
     * The account that the contact list runs against.
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The first group in the contact filter
     */
    @JsonProperty("RootGroup")
    private FilterGroup rootGroup;

    /**
     * The name of the contact list.
     */
    @JsonProperty("name")
    private String name;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public FilterGroup getRootGroup() {
        return rootGroup;
    }

    public void setRootGroup(FilterGroup rootGroup) {
        this.rootGroup = rootGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
