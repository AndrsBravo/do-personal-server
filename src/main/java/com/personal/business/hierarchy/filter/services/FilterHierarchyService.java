package com.personal.business.hierarchy.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchy.factories.HierarchyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterHierarchyService implements IFilterService<Hierarchy> {

    private final Optional<DbClient> dbClient;

    public FilterHierarchyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<Hierarchy>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return HierarchyResultFactory.FetchNull();
        }

        var queryString = query.Select("business_hierarchies",
                "id", "bssh_hierarchy", "bssh_title", "bssh_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new Hierarchy();
                    u.setId(dbRow.column("id").getString());
                    u.setHierarchy(dbRow.column("bssh_hierarchy").getString());
                    u.setTitle(dbRow.column("bssh_title").getString());
                    u.setDescription(dbRow.column("bssh_description").getString());
                    u.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return HierarchyResultFactory.FetchNull();
        }

        return HierarchyResultFactory.FetchResult(result);
    }
}
