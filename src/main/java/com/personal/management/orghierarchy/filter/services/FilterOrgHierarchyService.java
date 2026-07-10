package com.personal.management.orghierarchy.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.country.entities.Country;
import com.personal.management.orghierarchy.entities.OrgHierarchy;
import com.personal.management.orghierarchy.factories.OrgHierarchyResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterOrgHierarchyService implements IFilterService<OrgHierarchy> {

    private final Optional<DbClient> dbClient;

    public FilterOrgHierarchyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<OrgHierarchy>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return OrgHierarchyResultFactory.FetchNull();
        }

        var queryString = query.Select("organization_hierarchies",
                "id", "country_id", "orgh_hierarchy", "orgh_title", "orgh_description", "orgh_level", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(OrgHierarchy::new)
                .With(OrgHierarchy::setId, dbRow.column("id").getString())
                .With(OrgHierarchy::setLevel, dbRow.column("orgh_level").get(Short.class))
                .With(OrgHierarchy::setHierarchy, dbRow.column("orgh_hierarchy").getString())
                .With(OrgHierarchy::setTitle, dbRow.column("orgh_title").getString())
                .With(OrgHierarchy::setDescription, dbRow.column("orgh_description").getString())
                .With(OrgHierarchy::setCountry, new Country(dbRow.column("country_id").getString()))
                .With(OrgHierarchy::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(OrgHierarchy::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(OrgHierarchy::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return OrgHierarchyResultFactory.FetchNull();
        }

        return OrgHierarchyResultFactory.FetchResult(result);
    }
}
