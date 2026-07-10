package com.personal.backoffice.client.commercialplan.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.client.entities.ClientCommercialPlan;
import com.personal.backoffice.client.factories.ClientResultFactory;
import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterClientCommercialPlanService implements IFilterService<ClientCommercialPlan> {

    private final Optional<DbClient> dbClient;

    public FilterClientCommercialPlanService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<ClientCommercialPlan>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return ClientResultFactory.FilterCommercialPlanFail();
        }

        var queryString = query.Select("client_commercial_plan",
                "id", "client_id", "commercial_plan_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map(
                        (dbRow) -> EntityBuilder.Of(ClientCommercialPlan::new)
                                .With(ClientCommercialPlan::setId, dbRow.column("id").getString())
                                .With(ClientCommercialPlan::setClient, new Client(dbRow.column("client_id").getString()))
                                .With(ClientCommercialPlan::setCommercialPlan, new CommercialPlan(dbRow.column("commercial_plan_id").getString()))
                                .With(ClientCommercialPlan::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                                .With(ClientCommercialPlan::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                                .With(ClientCommercialPlan::setCreatedBy, new User(dbRow.column("created_by").getString()))
                                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return ClientResultFactory.FilterCommercialPlanFail();
        }

        return ClientResultFactory.FilterCommercialPlanSuccess(result);
    }
}
