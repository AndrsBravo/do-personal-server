package com.personal.shared.services.entities;

public class ServiceResultBuilder extends ResultBuilder {

    public ServiceResultBuilder() {
        super(new ServiceResult());
    }

    public static ServiceResultBuilder build() {

        return new ServiceResultBuilder();
    }

}
