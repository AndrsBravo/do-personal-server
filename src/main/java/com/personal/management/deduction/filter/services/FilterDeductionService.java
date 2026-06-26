package com.personal.management.deduction.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.deduction.entities.Deduction;
import com.personal.management.deduction.factories.DeductionResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterDeductionService implements IFilterService<Deduction> {

    private final Optional<DbClient> dbClient;

    public FilterDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<Deduction>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return DeductionResultFactory.FetchNull();
        }

        var queryString = query.Select("business_deductions",
                "id", "bd_deduction", "bd_title", "bd_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(Deduction::new)
                .With(Deduction::setId, dbRow.column("id").getString())
                .With(Deduction::setDeduction, dbRow.column("bd_deduction").getString())
                .With(Deduction::setTitle, dbRow.column("bd_title").getString())
                .With(Deduction::setDescription, dbRow.column("bd_description").getString())
                .With(Deduction::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(Deduction::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(Deduction::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return DeductionResultFactory.FetchNull();
        }

        return DeductionResultFactory.FetchResult(result);
    }
}
