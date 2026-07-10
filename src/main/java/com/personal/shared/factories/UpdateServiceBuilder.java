package com.personal.shared.factories;

public class UpdateServiceBuilder extends ServiceBuilder<UpdateService> {

    public UpdateServiceBuilder() {
        super(new UpdateService());
    }

    public static UpdateServiceBuilder builder() {
        return new UpdateServiceBuilder();
    }

    @Override
    public UpdateService build() {
        return this.instance;
    }

}
