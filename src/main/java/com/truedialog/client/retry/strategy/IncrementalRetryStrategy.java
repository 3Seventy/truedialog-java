package com.truedialog.client.retry.strategy;

/**
 * In incrementing retry strategy.
 * <p>
 * An incrementing retry strategy will add a fixed amount of time to each attempt.
 * </p>
 * <example>
 * The times returned might look like the following:
 * 500ms, 1000ms, 1500ms, 2000ms, and so on.
 * </example>
 */
public class IncrementalRetryStrategy extends RetryStrategy {

    @Override
    public String getName() {
        return "Incremental Retry";
    }

    @Override
    protected double getDelay(int attempt) {
        return interval * attempt;
    }
}