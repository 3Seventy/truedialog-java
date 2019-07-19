package com.truedialog.client.model.base;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.ResourceStatus;

/**
 * Base type for objects that are not removed when delete is called, but rather are placed in a deleted state.
 *
 * <p>
 * The {@code statusId} field is not directly settable by us. It is instead changed when an HTTP <tt>DELETE</tt> call is
 * made on this object type.
 * </p>
 *
 * @author Bryce Simonds
 */
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public class SoftDeletable extends BaseAudited
{
    /**
     * The current status of the object.
     */
    @JsonProperty("StatusId")
    private int statusId;

    /**
     * Gets the current status of the object.
     * <p>
     * The object's status is not directly settable. Instead it is changed when an HTTP <tt>DELETE</tt> call is made.
     * </p>
     *
     * @see SoftDeletable#getStatus()
     */
    public int getStatusId()
    {
        return statusId;
    }

    /**
     * Gets the current status of the object.
     * <p>
     * The object's status is not directly settable. Instead it is changed when an HTTP <tt>DELETE</tt> call is made.
     * </p>
     * <p>
     * This is an enumeration wrapper for the {@code StatusId}
     * </p>
     *
     * @see SoftDeletable#getStatusId()
     */
    public ResourceStatus getStatus()
    {
        return ResourceStatus.resourceStatus(statusId);
    }
}