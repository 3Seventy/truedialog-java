package com.truedialog.client.retry;

import com.truedialog.client.retry.strategy.RetryStrategy;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;

public class RetryPolicy<TDetector extends IRetryDetectionStrategy> implements IRetryPolicy {

    private final RetryStrategy retryStrategy;
    private final TDetector detect;

    public RetryPolicy(RetryStrategy retryStrategy, TDetector tDetector) {
        this.retryStrategy = retryStrategy;
        this.detect = tDetector;
    }

    private void internalExecute(Consumer<Integer> action) {
        int attempt = 0;
        RetryStrategy.Delay delay = new RetryStrategy.Delay();

        for (; ; ) {
            ++attempt;

            try {
                action.accept(attempt);
                break; // The action was successful if we got here, exit the loop.
            } catch (Exception ex) {
                if (!detect.IsTransient(ex))
                    throw ex; // Error is not transient, send it up the stack.

                if (!retryStrategy.shouldRetry(attempt, ex, delay))
                    throw ex; // We've maxed out our retry attempts, send it up.

                try {
                    Thread.sleep(delay.value);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    @Override
    public void executeVoid(Consumer<Integer> action) {
        internalExecute(action);
    }

    @Override
    public <T> T execute(Function<Integer, T> action) {
        AtomicReference<T> t = new AtomicReference<>();
        internalExecute(attempt -> t.set(action.apply(attempt)));
        return t.get();
    }
}
