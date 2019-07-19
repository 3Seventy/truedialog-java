package com.truedialog.client.retry;

import com.truedialog.client.exceptions.NetworkException;
import retrofit2.HttpException;

/**
 * Detection strategy for figuring out if we should retry or rest request or not.
 */
public class RestErrorDetectionStrategy implements IRetryDetectionStrategy {
    /**
     * Checks to see if the supplied exception is a transient error.
     *
     * @param ex The exception to check.
     * @return True if this is a transient fault, false if not.
     */
    @Override
    public boolean IsTransient(Exception ex) {
        if (ex instanceof HttpException) {
            HttpException httpEx = (HttpException) ex;
            // Only retry on 500 type errors, all other errors we pass on to the caller.
            return (httpEx.code() >= 500);
        }

        // Retry on network errors only, all other exceptions we pass on to the caller.
        return (ex instanceof NetworkException);
    }
}
