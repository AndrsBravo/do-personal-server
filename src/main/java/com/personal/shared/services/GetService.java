package com.personal.shared.services;

import java.util.Optional;

import com.personal.shared.services.entities.GetResultBuilder;

import io.helidon.dbclient.DbClient;

public abstract class GetService<T> implements IGetService<T> {

    protected final Optional<DbClient> dbClient;
    protected final GetResultBuilder<T> builder;

    public GetService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
        this.builder = GetResultBuilder.<T>build();
    }

}
