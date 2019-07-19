package com.truedialog.client.model.contact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.DataType;
import com.truedialog.client.model.base.BaseAudited;

public class ContactAttributeDefinition extends BaseAudited {

    /**
     * The Account ID that owns this attribute.
     */
    @JsonProperty("AccountId")
    private int accountId;
    /**
     * The ID of the data type for this attribute.
     */
    @JsonProperty("DataTypeId")
    public int dataTypeId;
    /**
     * Enumeration mapping for DataTypeId
     */
    @JsonIgnore
    public DataType dataType;
    /**
     * The Id of category
     */
    @JsonProperty("CategoryId")
    public int categoryId;

    /**
     * name of the attribute definition.
     */
    @JsonProperty("Name")
    public String name;
    /**
     * A full description of this attribute.
     */
    @JsonProperty("Description")
    public String description;


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(int dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public DataType getDataType() {

        return DataType.dataType(dataTypeId);
    }

    public void setDataType(DataType dataType) {
        this.dataTypeId = dataType.getValue();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
