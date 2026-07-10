package com.personal.shared.services.entities;

public class ServiceResult<T> extends CreateResult {

    private T result;

    public ServiceResult(T result) {

        this.result = result;

    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
