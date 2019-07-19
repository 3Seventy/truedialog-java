package com.truedialog.client.retry;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Interface for a class that will execute the supplied action with a retry logic.
 */
public interface IRetryPolicy {
    /**
     * @param action The action to execute
     */
    void executeVoid(Consumer<Integer> action);

    /**
     * @param action The function to execute.
     */
    <T> T execute(Function<Integer, T> action);

}