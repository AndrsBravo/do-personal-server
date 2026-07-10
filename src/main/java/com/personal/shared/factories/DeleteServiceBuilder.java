package com.personal.shared.factories;

public class DeleteServiceBuilder extends ServiceBuilder<DeleteService> {

    public DeleteServiceBuilder() {
        super(new DeleteService());
    }

    public static DeleteServiceBuilder builder() {
        return new DeleteServiceBuilder();
    }

    @Override
    public DeleteService build() {
        return this.instance;
    }

}
