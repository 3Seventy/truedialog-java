package com.truedialog.client.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.DataType;
import com.truedialog.client.model.base.Base;

/**
 * Account attribute definition
 */
public class AccountAttributeDefinition extends Base {
    /**
     * The account which defined this attribute.
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * Attribute definition category
     */
    @JsonProperty("CategoryId")
    private int categoryId;

    /**
     * The data type of the attribute
     */
    @JsonProperty("DataType")
    private int dataTypeId;

    /**
     * The name of the attribute.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Set if this attribute is inheritable, that is to say that child accounts will get this value from their parents if not directly set.
     */
    @JsonProperty("Inheritable")
    private boolean inheritable;

    /**
     * Freeform description of the attribute.
     */
    @JsonProperty("Description")
    private String description;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(int dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInheritable() {
        return inheritable;
    }

    public void setInheritable(boolean inheritable) {
        this.inheritable = inheritable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataType getDataType() {
        return DataType.dataType(dataTypeId);
    }

    public void setDataType(DataType dataType) {
        dataTypeId = dataType.getValue();
    }
}
