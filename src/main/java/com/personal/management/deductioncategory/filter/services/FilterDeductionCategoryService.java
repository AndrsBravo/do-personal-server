package com.personal.management.deductioncategory.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.deductioncategory.entities.DeductionCategory;
import com.personal.management.deductioncategory.factories.DeductionCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterDeductionCategoryService implements IFilterService<DeductionCategory> {

    private final Optional<DbClient> dbClient;

    public FilterDeductionCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<DeductionCategory>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return DeductionCategoryResultFactory.FetchNull();
        }

        var queryString = query.Select("deductions_categories",
                "id", "dc_category", "dc_title", "dc_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new DeductionCategory();
                    u.setId(dbRow.column("id").getString());
                    u.setCategory(dbRow.column("dc_category").getString());
                    u.setTitle(dbRow.column("dc_title").getString());
                    u.setDescription(dbRow.column("dc_description").getString());
                    u.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return DeductionCategoryResultFactory.FetchNull();
        }

        return DeductionCategoryResultFactory.FetchResult(result);
    }
}
