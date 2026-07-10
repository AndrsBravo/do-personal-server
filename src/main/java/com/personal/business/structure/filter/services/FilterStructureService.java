package com.personal.business.structure.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.structure.entities.Structure;
import com.personal.business.structure.factories.StructureResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterStructureService implements IFilterService<Structure> {

    private final Optional<DbClient> dbClient;

    public FilterStructureService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<Structure>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return StructureResultFactory.FetchNull();
        }

        var queryString = query.Select("business_structures",
                "id", "bss_structure", "bss_title", "bss_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(Structure::new)
                .With(Structure::setId, dbRow.column("id").getString())
                .With(Structure::setStructure, dbRow.column("bss_structure").getString())
                .With(Structure::setTitle, dbRow.column("bss_title").getString())
                .With(Structure::setDescription, dbRow.column("bss_description").getString())
                .With(Structure::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(Structure::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(Structure::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return StructureResultFactory.FetchNull();
        }

        return StructureResultFactory.FetchResult(result);
    }
}
