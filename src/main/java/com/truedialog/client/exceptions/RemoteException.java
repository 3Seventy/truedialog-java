package com.truedialog.client.exceptions;

import com.truedialog.client.model.error.ErrorDetail;

import java.util.Arrays;
import java.util.Collection;

/**
 * An exception that is returned by the remote server when an error is detected.
 * <p>
 * RemoteException errors are often returned when the server returns a 400 or other HTTP error.
 */
public class RemoteException extends RuntimeException {
    /**
     * Serialization versioning constant.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The remote HTTP status code we got back.
     */
    private int statusCode;

    /**
     * A list of erorrs that were parsed from the server's response.
     */
    private Collection<ErrorDetail> errors;

    /**
     * Constructor
     *
     * @param statusCode The HTTP status code that was received.
     * @param errors     The list of remote validation errors received.
     */
    public RemoteException(int statusCode, Collection<ErrorDetail> errors) {
        super(GenerateMessage(errors));

        this.statusCode = statusCode;
        this.errors = errors;
    }

    /**
     * Constructor
     *
     * @param statusCode The HTTP status code that was received.
     * @param errors     The list of remote validation errors that was received.
     * @param cause      The exception which caused this exception.
     */
    public RemoteException(int statusCode, Collection<ErrorDetail> errors, Throwable cause) {
        super(GenerateMessage(errors), cause);

        this.statusCode = statusCode;
        this.errors = errors;
    }

    /**
     * Returns the HTTP status code that was sent by the server.
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Returns the list of errors that were parsed from the server.
     */
    public Collection<ErrorDetail> getErrors() {
        return errors;
    }

    /**
     * Convert the given errors to a string.
     * <p>
     * Used for setting the message property of the base Exception class.
     *
     * @param errors The list of errors to convert to a string.
     * @return A string representing the errors.
     */
    private static String GenerateMessage(Collection<ErrorDetail> errors) {
        return Arrays.toString(errors.toArray());
    }
}