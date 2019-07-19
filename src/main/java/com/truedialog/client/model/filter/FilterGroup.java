package com.truedialog.client.model.filter;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.Base;

import java.util.List;

public class FilterGroup extends Base{

    /**
     * The account that owns the group.
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The owning contact list of this filter group.
     */
    @JsonProperty("ContactListId")
    private int contactListId;

    /**
     * The parent group, if any.  NULL for root groups.
     */
    @JsonProperty("ParentId")
    private int parentId;

    /**
     * The operation to perform on each child item.
     * Must either be 'AND' or 'OR'
     */
    @JsonProperty("Operator")
    private String operator;

    /**
     * List of sub groups
     */
    @JsonProperty("Groups")
    public List<FilterGroup> groups;

    /**
     * List of filters directly in this group.
     */
    @JsonProperty("Filters")
    public List<ContactFilter> filters;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getContactListId() {
        return contactListId;
    }

    public void setContactListId(int contactListId) {
        this.contactListId = contactListId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<FilterGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<FilterGroup> groups) {
        this.groups = groups;
    }

    public List<ContactFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<ContactFilter> filters) {
        this.filters = filters;
    }
}
