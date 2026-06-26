package com.personal.shared.entities;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class EntityBuilder<T> {

    private final T entity;

    public EntityBuilder(Supplier<T> entity) {
        this.entity = entity.get();
    }

    public static <E> EntityBuilder<E> Of(Supplier<E> entity) {
        return new EntityBuilder<>(entity);
    }

    public <E> EntityBuilder<T> With(BiConsumer<T, E> property, E value) {
        property.accept(entity, value);
        return this;
    }

    public T Get() {
        return entity;
    }

}
