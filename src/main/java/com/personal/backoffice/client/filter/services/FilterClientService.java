package com.personal.backoffice.client.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.client.factories.ClientResultFactory;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterClientService implements IFilterService<Client> {

    private final Optional<DbClient> dbClient;

    public FilterClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<Client>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return ClientResultFactory.FetchNull();
        }

        var queryString = query.Select("clients",
                "id", "c_types_id", "c_updated_at", "c_created_at", "c_created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow)
                        -> EntityBuilder.Of(Client::new)
                        .With(Client::setId, dbRow.column("id").getString())
                        .With(Client::setClientType, new TypeEntityBase(dbRow.column("c_types_id").getString()))
                        .With(Client::setCreatedAt, dbRow.column("c_created_at").get(LocalDateTime.class))
                        .With(Client::setUpdatedAt, dbRow.column("c_updated_at").get(LocalDateTime.class))
                        .With(Client::setCreatedBy, new User(dbRow.column("c_created_by").getString()))
                        .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return ClientResultFactory.FetchNull();
        }

        return ClientResultFactory.FetchResult(result);
    }
}
