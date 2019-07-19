package com.truedialog.client.retry.strategy;


/**
 * Wrapper around if we should retry a request.
 */
public abstract class RetryStrategy {
    /**
     * Gets the name of the retry strategy.
     */
    public abstract String getName();

    /**
     * Gets or sets the maximum number of tries we should go for.
     */
    public byte maxTries;

    /**
     * Gets or sets the initial amount of time for a retry.
     */
    public long interval;

    /**
     * Gets or sets the minimum amount of time we should delay by.
     */
    public long minInterval;

    /**
     * Gets or sets the maximum amount of time we should delay by.
     */
    public long maxInterval;

    /**
     * Gets the delay we should wait for if we attempt to retry.
     */
    protected abstract double getDelay(int attempt);

    /**
     * Checks to see if the call should be retried.
     *
     * @param attempt       The attempt # that was tried.
     * @param lastException The exception (if any) that we got.
     * @param delay         The delay we should wait for before trying again.
     * @return true if we should retry, false if not.
     */
    public boolean shouldRetry(int attempt, Exception lastException, Delay delay) {
        double delayUSec = getDelay(attempt);

        delayUSec = Math.min(delayUSec, maxInterval);
        delayUSec = Math.max(delayUSec, minInterval);

        delay.value = (long) delayUSec;

        return (attempt < maxTries);
    }

    public static class Delay {
        public long value;
    }
}