package com.truedialog.client.model.error;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.ErrorCode;

/**
 * Details of a remote error
 *
 * @author Bryce Simonds
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ErrorDetail {
    @JsonProperty("ErrorCodeId")
    private int errorCodeId;

    @JsonProperty("ErrorMessage")
    private String errorMessage;

    @JsonProperty("ObjectType")
    private String objectType;

    @JsonProperty("PropertyName")
    private String propertyName;

    /**
     * Gets a generic error code for looking up the details.
     * <p>
     * This error code is useful for performing i18n operations, or performing error specific actions if need be.
     * </p>
     * <p>
     * Example: <code>PROPERTY_REQUIRED (0x02000000)</code>
     * </p>
     */
    public ErrorCode getErrorCode() {
        return ErrorCode.fromInteger(errorCodeId);
    }

    /**
     * Gets a basic error message to use if looking up by error code is not possible.
     * <p>
     * Example: <code>"The name property is required"</code>
     * </p>
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Gets a string representing the type of object that failed validation.
     * <p>
     * Example: <code>"Account"</code>
     * </p>
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * Returns the specific property that failed the validation.
     * <p>
     * Example: <code>"name"</code>
     * </p>
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the error code.
     */
    public void setErrorCode(ErrorCode errorCode) {
        errorCodeId = errorCode.getValue();
    }

    /**
     * Sets the error message.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Sets the object type.
     */
    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    /**
     * Sets the property name.
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
