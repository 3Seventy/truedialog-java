package com.truedialog.client.retry.strategy;

/**
 * An exponential retry strategy.
 * <p>
 * Exponential retry strategies will add an ever increasing amount of time.
 * </p>
 * * <example>
 * The times returned might look like the following:
 * 500ms, 1000ms, 2000ms, 4000ms, and so on.
 * </example>
 */
public class ExponentialRetryStrategy extends RetryStrategy {

    @Override
    public String getName() {
        return "Exponential Retry";
    }

    @Override
    protected double getDelay(int attempt) {
        int scale = 1 << (attempt - 1);
        return interval * scale;
    }
}
