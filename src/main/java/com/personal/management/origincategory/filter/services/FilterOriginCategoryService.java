package com.personal.management.origincategory.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.origincategory.entities.OriginCategory;
import com.personal.management.origincategory.factories.OriginCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterOriginCategoryService implements IFilterService<OriginCategory> {

    private final Optional<DbClient> dbClient;

    public FilterOriginCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<OriginCategory>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return OriginCategoryResultFactory.FetchNull();
        }

        var queryString = query.Select("origin_categories",
                "id", "oc_origin", "oc_title", "oc_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new OriginCategory();
                    u.setId(dbRow.column("id").getString());
                    u.setOrigin(dbRow.column("oc_origin").getString());
                    u.setTitle(dbRow.column("oc_title").getString());
                    u.setDescription(dbRow.column("oc_description").getString());
                    u.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return OriginCategoryResultFactory.FetchNull();
        }

        return OriginCategoryResultFactory.FetchResult(result);
    }
}
