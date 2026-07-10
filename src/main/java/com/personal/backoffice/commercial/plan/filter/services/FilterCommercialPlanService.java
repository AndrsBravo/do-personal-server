package com.personal.backoffice.commercial.plan.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.commercial.plan.factories.CommercialPlanResultFactory;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterCommercialPlanService implements IFilterService<CommercialPlan> {

    private final Optional<DbClient> dbClient;

    public FilterCommercialPlanService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<CommercialPlan>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return CommercialPlanResultFactory.FetchNull();
        }

        var queryString = query.Select("commercial_plan",
                "id", "cp_plan", "cp_title", "cp_description", "cp_updated_at", "cp_created_at", "cp_created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow)
                        -> EntityBuilder.Of(CommercialPlan::new)
                        .With(CommercialPlan::setId, dbRow.column("id").getString())
                        .With(CommercialPlan::setPlan, dbRow.column("cp_plan").getString())
                        .With(CommercialPlan::setTitle, dbRow.column("cp_title").getString())
                        .With(CommercialPlan::setDescription, dbRow.column("cp_description").getString())
                        .With(CommercialPlan::setCreatedAt, dbRow.column("cp_created_at").get(LocalDateTime.class))
                        .With(CommercialPlan::setUpdatedAt, dbRow.column("cp_updated_at").get(LocalDateTime.class))
                        .With(CommercialPlan::setCreatedBy, new User(dbRow.column("cp_created_by").getString()))
                        .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return CommercialPlanResultFactory.FetchNull();
        }

        return CommercialPlanResultFactory.FetchResult(result);
    }
}
