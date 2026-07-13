package com.personal.shared.services.entities;

public class GetResult<T> extends ServiceResult {

    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
