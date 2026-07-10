package com.personal.shared.factories;

public class CreateServiceBuilder extends ServiceBuilder<CreateService> {

    public CreateServiceBuilder() {
        super(new CreateService());
    }

    public static CreateServiceBuilder builder() {
        return new CreateServiceBuilder();
    }

    @Override
    public CreateService build() {
        return this.instance;
    }

}
