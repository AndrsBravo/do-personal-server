package com.personal.backoffice.client.commercialplan.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.client.entities.ClientCommercialPlan;
import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.commercial.plan.notifications.CommercialPlanNotificationFactory;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterClientCommercialPlanService extends FilterService<ClientCommercialPlan> {

    public FilterClientCommercialPlanService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<ClientCommercialPlan> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("client_commercial_plan",
                "id", "client_id", "commercial_plan_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
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
            builder.withResult(result)
                    .withNotification(CommercialPlanNotificationFactory.FetchCommercialPlanSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(CommercialPlanNotificationFactory.FetchCommercialPlanFail());
        }
        return builder.get();
    }
}
