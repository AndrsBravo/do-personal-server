package com.personal.business.orghierarchy.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.orghierarchy.entities.OrgHierarchy;
import com.personal.business.orghierarchy.factories.OrgHierarchyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

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
                "id", "orgh_hierarchy", "orgh_title", "orgh_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new OrgHierarchy();
                    u.setId(dbRow.column("id").getString());
                    u.setHierarchy(dbRow.column("orgh_hierarchy").getString());
                    u.setTitle(dbRow.column("orgh_title").getString());
                    u.setDescription(dbRow.column("orgh_description").getString());
                    u.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return OrgHierarchyResultFactory.FetchNull();
        }

        return OrgHierarchyResultFactory.FetchResult(result);
    }
}
