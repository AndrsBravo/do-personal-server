package com.personal.management.financecategory.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.financecategory.entities.FinanceCategory;
import com.personal.management.financecategory.factories.FinanceCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterFinanceCategoryService implements IFilterService<FinanceCategory> {

    private final Optional<DbClient> dbClient;

    public FilterFinanceCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<FinanceCategory>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return FinanceCategoryResultFactory.FetchNull();
        }

        var queryString = query.Select("finance_categories",
                "id", "fc_category", "fc_title", "fc_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new FinanceCategory();
                    u.setId(dbRow.column("id").getString());
                    u.setCategory(dbRow.column("fc_category").getString());
                    u.setTitle(dbRow.column("fc_title").getString());
                    u.setDescription(dbRow.column("fc_description").getString());
                    u.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return FinanceCategoryResultFactory.FetchNull();
        }

        return FinanceCategoryResultFactory.FetchResult(result);
    }
}
