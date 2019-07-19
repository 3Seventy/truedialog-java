package com.truedialog.client.config;


import com.truedialog.client.retry.strategy.RetryStrategy;

/**
 * Details about the retry policy configuration for errored requests.
 */
public class RetryConfig {

    /**
     * Set to false to disable retry policy
     */
    private boolean enabled;

    /**
     * The maximum number of times we should attempt to retry the request before giving up.
     */
    private int maxTries;

    /**
     * The minimum allowed value for timeouts.
     * <p>
     * For incremental, and exponential policies this value is the base value.
     * </p>
     */
    private long minInterval;

    /**
     * The maximum allowed value for timeouts.
     * <p>
     * For incremental, and exponential policies this value is the base value.
     * </p>
     */
    private long maxInterval;

    /**
     * How often (in miliseconds) we should attempt to retry.
     * <p>
     * For incremental, and exponential policies this value is the base value.
     * </p>
     */
    private long interval;

    private String typeName;

    public Class getType() throws ClassNotFoundException {
        Class type = Class.forName(typeName, false, getClass().getClassLoader());

        if (!type.isAssignableFrom(RetryStrategy.class)) {
            throw new IllegalArgumentException("Type must be an IRetryPolicy");
        }

        return type;
    }

    public void setTypeName(String typeName) throws ClassNotFoundException {
        Class type = Class.forName(typeName);
        if (!type.isAssignableFrom(RetryConfig.class)) {
            throw new IllegalArgumentException("Type must be an IRetryPolicy");
        }
        this.typeName = type.getCanonicalName();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    public long getMinInterval() {
        return minInterval;
    }

    public void setMinInterval(long minInterval) {
        this.minInterval = minInterval;
    }

    public long getMaxInterval() {
        return maxInterval;
    }

    public void setMaxInterval(long maxInterval) {
        this.maxInterval = maxInterval;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }
}
