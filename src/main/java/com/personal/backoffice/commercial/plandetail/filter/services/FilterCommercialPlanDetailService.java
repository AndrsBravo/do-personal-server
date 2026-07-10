package com.personal.backoffice.commercial.plandetail.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.backoffice.commercial.plandetail.factories.CommercialPlanDetailResultFactory;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterCommercialPlanDetailService implements IFilterService<CommercialPlanDetail> {

    private final Optional<DbClient> dbClient;

    public FilterCommercialPlanDetailService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<CommercialPlanDetail>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return CommercialPlanDetailResultFactory.FetchNull();
        }

        var queryString = query.Select("commercial_plan_details",
                "id", "commercial_plan_id", "commercial_entities_id", "cpd_quantity", "cpd_updated_at", "cpd_created_at", "cpd_created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow)
                        -> EntityBuilder.Of(CommercialPlanDetail::new)
                        .With(CommercialPlanDetail::setId, dbRow.column("id").getString())
                        .With(CommercialPlanDetail::setPlan, new CommercialPlan(dbRow.column("commercial_plan_id").getString()))
                        .With(CommercialPlanDetail::setEntity, new CommercialEntity(dbRow.column("commercial_entities_id").getString()))
                        .With(CommercialPlanDetail::setQuantity, Integer.valueOf(dbRow.column("cpd_quantity").getString()))
                        .With(CommercialPlanDetail::setCreatedAt, dbRow.column("cpd_created_at").get(LocalDateTime.class))
                        .With(CommercialPlanDetail::setUpdatedAt, dbRow.column("cpd_updated_at").get(LocalDateTime.class))
                        .With(CommercialPlanDetail::setCreatedBy, new User(dbRow.column("cpd_created_by").getString()))
                        .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return CommercialPlanDetailResultFactory.FetchNull();
        }

        return CommercialPlanDetailResultFactory.FetchResult(result);
    }
}
