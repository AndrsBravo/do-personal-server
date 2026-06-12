package com.personal.business.orgrelation.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.orghierarchy.entities.OrgHierarchy;
import com.personal.business.orgrelation.entities.OrgRelation;
import com.personal.business.orgrelation.factories.OrgRelationResultFactory;
import com.personal.business.orgstructure.entities.OrgStructure;
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
                "id", "organization_structure", "organization_hierarchy", "orgs_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var or = new OrgRelation();
                    or.setId(dbRow.column("id").getString());
                    or.setStructure(new OrgStructure(dbRow.column("organization_structure").getString()));
                    or.setHierarchy(new OrgHierarchy(dbRow.column("organization_hierarchy").getString()));
                    or.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    or.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    or.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return or;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return OrgRelationResultFactory.FetchNull();
        }

        return OrgRelationResultFactory.FetchResult(result);
    }
}
