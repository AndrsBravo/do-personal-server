package com.personal.shared.services.entities;

public class GetResultBuilder<T> extends ResultBuilder<GetResult<T>> {

    public GetResultBuilder() {
        super(new GetResult<>());
    }

    public static <T> GetResultBuilder<T> build() {

        return new GetResultBuilder<>();
    }

    public GetResultBuilder<T> withResult(T result) {
        this.instance.setResult(result);
        return this;
    }

}
