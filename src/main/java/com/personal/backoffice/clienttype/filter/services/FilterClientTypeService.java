package com.personal.backoffice.clienttype.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.clienttype.factories.ClientTypeResultFactory;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterClientTypeService implements IFilterService<TypeEntityBase> {

    private final Optional<DbClient> dbClient;

    public FilterClientTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<TypeEntityBase>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return ClientTypeResultFactory.FetchNull();
        }

        var queryString = query.Select("client_types",
                "id", "ct_type", "ct_title", "ct_description", "ct_updated_at", "ct_created_at", "ct_created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow)
                        -> EntityBuilder.Of(TypeEntityBase::new)
                        .With(TypeEntityBase::setId, dbRow.column("id").getString())
                        .With(TypeEntityBase::setType, dbRow.column("ct_type").getString())
                        .With(TypeEntityBase::setTitle, dbRow.column("ct_title").getString())
                        .With(TypeEntityBase::setDescription, dbRow.column("ct_description").getString())
                        .With(TypeEntityBase::setCreatedAt, dbRow.column("ct_created_at").get(LocalDateTime.class))
                        .With(TypeEntityBase::setUpdatedAt, dbRow.column("ct_updated_at").get(LocalDateTime.class))
                        .With(TypeEntityBase::setCreatedBy, new User(dbRow.column("ct_created_by").getString()))
                        .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return ClientTypeResultFactory.FetchNull();
        }

        return ClientTypeResultFactory.FetchResult(result);
    }
}
