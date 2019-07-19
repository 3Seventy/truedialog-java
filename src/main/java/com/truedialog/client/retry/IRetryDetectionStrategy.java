package com.truedialog.client.retry;

/**
 * Interface for transient error detection.
 */
interface IRetryDetectionStrategy {
    /**
     * Checks to see if the supplied exception is a transient error.
     *
     * @param ex The exception to check.
     * @return True if this is a transient fault, false if not
     */
    boolean IsTransient(Exception ex);
}