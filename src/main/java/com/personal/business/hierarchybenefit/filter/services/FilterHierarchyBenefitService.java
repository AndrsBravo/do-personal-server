package com.personal.business.hierarchybenefit.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.benefit.entities.Benefit;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.business.hierarchybenefit.notifications.HierarchyBenefitNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterHierarchyBenefitService extends FilterService<HierarchyBenefit> {

    public FilterHierarchyBenefitService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<HierarchyBenefit> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("hierarchies_benefits",
                "id", "business_id", "business_benefits_id", "business_hierarchy_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(HierarchyBenefit::new)
                    .With(HierarchyBenefit::setId, dbRow.column("id").getString())
                    .With(HierarchyBenefit::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(HierarchyBenefit::setBenefit, new Benefit(dbRow.column("business_benefits_id").getString()))
                    .With(HierarchyBenefit::setHierarchy, new Hierarchy(dbRow.column("business_hierarchy_id").getString()))
                    .With(HierarchyBenefit::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(HierarchyBenefit::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(HierarchyBenefit::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get()
                    )
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(HierarchyBenefitNotificationFactory.FetchHierarchyBenefitSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(HierarchyBenefitNotificationFactory.FetchHierarchyBenefitFail());
        }

        return builder.get();
    }
}
