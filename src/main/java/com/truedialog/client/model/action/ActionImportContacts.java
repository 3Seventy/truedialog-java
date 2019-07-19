package com.truedialog.client.model.action;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.ActionBase;
import com.truedialog.client.model.subscription.ContactSubscription;

import java.util.ArrayList;
import java.util.List;

/**
 * Lets you import conatcts
 */
public class ActionImportContacts extends ActionBase {

    /**
     * Points to a BLOB url that contains the file to parse.
     */
    @JsonProperty("Url")
    private String url;

    /**
     * A list of subscriptions that should be added or modified for each of the contacts in the supplied file.
     */

    @JsonProperty("Subscriptions")
    private List<ContactSubscription> subscriptions = new ArrayList<>();

    /**
     * Set to create contact list out of this import
     */
    @JsonProperty("CreateList")
    private boolean createList;

    /**
     * Set to include contacts that have been created during this import only
     */
    @JsonProperty("CreatedOnly")
    private boolean createdOnly;

    /**
     * Created list name
     */
    @JsonProperty("ListName")
    private String listName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ContactSubscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<ContactSubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public boolean isCreateList() {
        return createList;
    }

    public void setCreateList(boolean createList) {
        this.createList = createList;
    }

    public boolean isCreatedOnly() {
        return createdOnly;
    }

    public void setCreatedOnly(boolean createdOnly) {
        this.createdOnly = createdOnly;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}