package com.personal.shared.services;

import java.util.Optional;

import com.personal.shared.entities.Base;
import com.personal.shared.services.entities.FetchResultBuilder;

import io.helidon.dbclient.DbClient;

public abstract class FilterService<T extends Base> implements IFilterService<T> {

    protected final Optional<DbClient> dbClient;
    protected final FetchResultBuilder<T> builder;

    public FilterService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
        this.builder = FetchResultBuilder.<T>build();
    }

}
