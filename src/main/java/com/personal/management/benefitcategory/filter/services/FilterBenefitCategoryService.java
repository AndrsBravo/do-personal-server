package com.personal.management.benefitcategory.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.benefitcategory.entities.BenefitCategory;
import com.personal.management.benefitcategory.factories.BenefitCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterBenefitCategoryService implements IFilterService<BenefitCategory> {

    private final Optional<DbClient> dbClient;

    public FilterBenefitCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<BenefitCategory>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return BenefitCategoryResultFactory.FetchNull();
        }

        var queryString = query.Select("benefit_categories",
                "id", "bc_category", "bc_title", "bc_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new BenefitCategory();
                    u.setId(dbRow.column("id").getString());
                    u.setCategory(dbRow.column("bc_category").getString());
                    u.setTitle(dbRow.column("bc_title").getString());
                    u.setDescription(dbRow.column("bc_description").getString());
                    u.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return BenefitCategoryResultFactory.FetchNull();
        }

        return BenefitCategoryResultFactory.FetchResult(result);
    }
}
