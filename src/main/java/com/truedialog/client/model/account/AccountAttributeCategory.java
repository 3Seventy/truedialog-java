package com.truedialog.client.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.model.base.Base;

/**
 * Account attribute category details.
 */
public class AccountAttributeCategory extends Base {
    /**
     * The name of this category.
     */
    @JsonProperty("Name")
    private String Name;

    /**
     * The description of this category.
     */
    @JsonProperty("Description")
    private String Description;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}