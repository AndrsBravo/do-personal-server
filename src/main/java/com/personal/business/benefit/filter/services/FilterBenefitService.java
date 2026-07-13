package com.personal.business.benefit.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.benefit.entities.Benefit;
import com.personal.business.benefit.notifications.BenefitNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterBenefitService extends FilterService<Benefit> {

    public FilterBenefitService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<Benefit> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("business_benefits",
                "id", "bb_benefit", "bb_title", "bb_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(Benefit::new)
                    .With(Benefit::setId, dbRow.column("id").getString())
                    .With(Benefit::setBenefit, dbRow.column("bb_benefit").getString())
                    .With(Benefit::setTitle, dbRow.column("bb_title").getString())
                    .With(Benefit::setDescription, dbRow.column("bb_description").getString())
                    .With(Benefit::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(Benefit::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(Benefit::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(BenefitNotificationFactory.FetchBenefitSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(BenefitNotificationFactory.FetchBenefitFail());
        }

        return builder.get();
    }
}
