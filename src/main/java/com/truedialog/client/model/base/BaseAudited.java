package com.truedialog.client.model.base;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Base class for objects with audit information.
 *
 * @author Bryce Simonds
 */
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public class BaseAudited extends Base
{
    /**
     * When the resource was created.
     */
    @JsonProperty("Created")
    private Date created;

    /**
     * Who created this object.
     */
    @JsonProperty("CreatedBy")
    private String createdBy;

    /**
     * When this object was last modified.
     */
    @JsonProperty("Modified")
    private Date modified;

    /**
     * Who last modified this object.
     */
    @JsonProperty("ModifiedBy")
    private String modifiedBy;

    /**
     * Gets the date when this resource was created.
     */
    public Date getCreated()
    {
        return created;
    }

    /**
     * Gets the date when this resource was last updated.
     */
    public Date getModified()
    {
        return modified;
    }

    /**
     * Gets the user who created this resource.
     * <p>
     * This is currently not filled in.
     * </p>
     */
    public String getCreatedBy()
    {
        return createdBy;
    }

    /**
     * Gets the user who last modified this resource.
     * <p>
     * This is currently not filled in.
     * </p>
     */
    public String getModifiedBy()
    {
        return modifiedBy;
    }
}
