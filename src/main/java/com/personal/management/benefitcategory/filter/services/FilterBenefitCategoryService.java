package com.personal.management.benefitcategory.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.benefitcategory.entities.BenefitCategory;
import com.personal.management.benefitcategory.notifications.BenefitCategoryNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterBenefitCategoryService extends FilterService<BenefitCategory> {

    public FilterBenefitCategoryService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<BenefitCategory> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("benefit_categories",
                "id", "bc_category", "bc_title", "bc_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(BenefitCategory::new)
                    .With(BenefitCategory::setId, dbRow.column("id").getString())
                    .With(BenefitCategory::setCategory, dbRow.column("bc_category").getString())
                    .With(BenefitCategory::setTitle, dbRow.column("bc_title").getString())
                    .With(BenefitCategory::setDescription, dbRow.column("bc_description").getString())
                    .With(BenefitCategory::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(BenefitCategory::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(BenefitCategory::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(BenefitCategoryNotificationFactory.FetchBenefitCategorySuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(BenefitCategoryNotificationFactory.FetchBenefitCategoryFail());
        }

        return builder.get();
    }
}
