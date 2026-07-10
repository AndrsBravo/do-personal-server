package com.personal.business.orgstructure.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.orgstructure.entities.OrgStructure;
import com.personal.business.orgstructure.factories.OrgStructureResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterOrgStructureService implements IFilterService<OrgStructure> {

    private final Optional<DbClient> dbClient;

    public FilterOrgStructureService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<OrgStructure>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return OrgStructureResultFactory.FetchNull();
        }

        var queryString = query.Select("organization_structures",
                "id", "orgs_structure", "orgs_title", "orgs_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(OrgStructure::new)
                .With(OrgStructure::setId, dbRow.column("id").getString())
                .With(OrgStructure::setLevel, dbRow.column("orgs_level").get(Short.class))
                .With(OrgStructure::setStructure, dbRow.column("orgs_structure").getString())
                .With(OrgStructure::setTitle, dbRow.column("orgs_title").getString())
                .With(OrgStructure::setDescription, dbRow.column("orgs_description").getString())
                .With(OrgStructure::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(OrgStructure::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(OrgStructure::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return OrgStructureResultFactory.FetchNull();
        }

        return OrgStructureResultFactory.FetchResult(result);
    }
}
