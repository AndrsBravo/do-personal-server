package com.personal.shared.services.entities;

import java.util.List;

public class FetchResultBuilder<T> extends ResultBuilder<FetchResult<T>> {

    public FetchResultBuilder() {
        super(new FetchResult<>());
    }

    public static <T> FetchResultBuilder<T> build() {

        return new FetchResultBuilder<>();
    }

    public FetchResultBuilder<T> withResult(List<T> result) {
        this.instance.setResult(result);
        return this;
    }

}
