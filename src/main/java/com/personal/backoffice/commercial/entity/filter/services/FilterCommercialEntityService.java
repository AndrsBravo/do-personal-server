package com.personal.backoffice.commercial.entity.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.commercial.entity.factories.CommercialEntityResultFactory;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterCommercialEntityService implements IFilterService<CommercialEntity> {

    private final Optional<DbClient> dbClient;

    public FilterCommercialEntityService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<CommercialEntity>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return CommercialEntityResultFactory.FetchNull();
        }

        var queryString = query.Select("commercial_entities",
                "id", "ce_entity", "ce_title", "ce_description", "ce_updated_at", "ce_created_at", "ce_created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow)
                        -> EntityBuilder.Of(CommercialEntity::new)
                        .With(CommercialEntity::setId, dbRow.column("id").getString())
                        .With(CommercialEntity::setEntity, dbRow.column("ce_entity").getString())
                        .With(CommercialEntity::setTitle, dbRow.column("ce_title").getString())
                        .With(CommercialEntity::setDescription, dbRow.column("ce_description").getString())
                        .With(CommercialEntity::setCreatedAt, dbRow.column("ce_created_at").get(LocalDateTime.class))
                        .With(CommercialEntity::setUpdatedAt, dbRow.column("ce_updated_at").get(LocalDateTime.class))
                        .With(CommercialEntity::setCreatedBy, new User(dbRow.column("ce_created_by").getString()))
                        .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return CommercialEntityResultFactory.FetchNull();
        }

        return CommercialEntityResultFactory.FetchResult(result);
    }
}
