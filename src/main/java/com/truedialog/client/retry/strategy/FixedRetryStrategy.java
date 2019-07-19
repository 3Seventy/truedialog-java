package com.truedialog.client.retry.strategy;

public class FixedRetryStrategy extends RetryStrategy {
    @Override
    public String getName() {
        return "Fixed Retry";
    }

    @Override
    protected double getDelay(int attempt) {
        return interval;
    }
}
