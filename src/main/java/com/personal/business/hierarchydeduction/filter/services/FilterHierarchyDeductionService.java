package com.personal.business.hierarchydeduction.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.deduction.entities.Deduction;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.business.hierarchydeduction.notifications.HierarchyDeductionNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterHierarchyDeductionService extends FilterService<HierarchyDeduction> {

    public FilterHierarchyDeductionService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<HierarchyDeduction> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("hierarchies_deductions",
                "id", "business_id", "business_deductions_id", "business_hierarchy_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(HierarchyDeduction::new)
                    .With(HierarchyDeduction::setId, dbRow.column("id").getString())
                    .With(HierarchyDeduction::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(HierarchyDeduction::setDeduction, new Deduction(dbRow.column("business_deductions_id").getString()))
                    .With(HierarchyDeduction::setHierarchy, new Hierarchy(dbRow.column("business_hierarchy_id").getString()))
                    .With(HierarchyDeduction::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(HierarchyDeduction::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(HierarchyDeduction::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get()
                    )
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(HierarchyDeductionNotificationFactory.FetchHierarchyDeductionSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(HierarchyDeductionNotificationFactory.FetchHierarchyDeductionFail());
        }

        return builder.get();
    }
}
