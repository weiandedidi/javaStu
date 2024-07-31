package com.qidi.bootdemo2.utils;

/**
 * @author maqidi
 * @version 1.0
 * @create 2024-07-31 16:01
 */
public class ExecutionResult<T> {
    private final T result;
    private final long executionTime;

    public ExecutionResult(T result, long executionTime) {
        this.result = result;
        this.executionTime = executionTime;
    }

    public T getResult() {
        return result;
    }

    public long getExecutionTime() {
        return executionTime;
    }


}
