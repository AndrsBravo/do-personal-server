package com.personal.management.orgrelation.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.orgrelation.entities.OrgRelation;
import com.personal.management.orgrelation.factories.OrgRelationResultFactory;
import com.personal.shared.core.entities.SharedOrgHierarchy;
import com.personal.shared.core.entities.SharedOrgStructure;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterOrgRelationService implements IFilterService<OrgRelation> {

    private final Optional<DbClient> dbClient;

    public FilterOrgRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<OrgRelation>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return OrgRelationResultFactory.FetchNull();
        }

        var queryString = query.Select("organization_relations",
                "id", "organization_structure", "organization_hierarchy", "updated_at", "created_at", "created_by")
                .InnerJoin("organization_structures", "orgs_structure", "orgs_title", "orgs_description", "orgs_level", "updated_at", "created_at", "created_by")
                .On("organization_relations", "organization_structure")
                .Equ("organization_structures", "id")
                .InnerJoin("organization_hierarchies", "orgh_hierarchy", "orgh_title", "orgh_description", "orgh_level", "updated_at", "created_at", "created_by")
                .On("organization_relations", "organization_hierarchy")
                .Equ("organization_hierarchies", "id")
                .Get();

        System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow)
                        -> EntityBuilder.Of(OrgRelation::new)
                        .With(OrgRelation::setId, dbRow.column("id").getString())
                        .With(OrgRelation::setStructure,
                                EntityBuilder.Of(SharedOrgStructure::new)
                                        .With(SharedOrgStructure::setId, dbRow.column("organization_structure").getString())
                                        .With(SharedOrgStructure::setLevel, dbRow.column("orgs_level").get(Short.class))
                                        .With(SharedOrgStructure::setStructure, dbRow.column("orgs_structure").getString())
                                        .With(SharedOrgStructure::setTitle, dbRow.column("orgs_title").getString())
                                        .With(SharedOrgStructure::setDescription, dbRow.column("orgs_description").getString())
                                        .Get()
                        )
                        .With(OrgRelation::setHierarchy,
                                EntityBuilder.Of(SharedOrgHierarchy::new)
                                        .With(SharedOrgHierarchy::setId, dbRow.column("organization_hierarchy").getString())
                                        .With(SharedOrgHierarchy::setLevel, dbRow.column("orgh_level").get(Short.class))
                                        .With(SharedOrgHierarchy::setHierarchy, dbRow.column("orgh_hierarchy").getString())
                                        .With(SharedOrgHierarchy::setTitle, dbRow.column("orgh_title").getString())
                                        .With(SharedOrgHierarchy::setDescription, dbRow.column("orgh_description").getString())
                                        .Get()
                        )
                        .With(OrgRelation::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                        .With(OrgRelation::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                        .With(OrgRelation::setCreatedBy, EntityBuilder.Of(User::new).With(User::setId, dbRow.column("created_by").getString()).Get())
                        .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return OrgRelationResultFactory.FetchNull();
        }

        return OrgRelationResultFactory.FetchResult(result);
    }
}
