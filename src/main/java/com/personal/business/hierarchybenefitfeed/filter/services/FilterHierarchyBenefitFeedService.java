package com.personal.business.hierarchybenefitfeed.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.benefit.entities.Benefit;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;
import com.personal.business.hierarchybenefitfeed.notifications.HierarchyBenefitFeedNotificationFactory;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterHierarchyBenefitFeedService extends FilterService<HierarchyBenefitFeed> {

    public FilterHierarchyBenefitFeedService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<HierarchyBenefitFeed> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("hierarchies_benefits_feeds",
                "id", "business_id", "business_benefits_id", "business_hierarchy_id", "temporal_frequency_id", "hbf_amount", "hbf_started_at", "hbf_ended_at", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(HierarchyBenefitFeed::new)
                    .With(HierarchyBenefitFeed::setId, dbRow.column("id").getString())
                    .With(HierarchyBenefitFeed::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(HierarchyBenefitFeed::setBenefit, new Benefit(dbRow.column("business_benefits_id").getString()))
                    .With(HierarchyBenefitFeed::setHierarchy, new Hierarchy(dbRow.column("business_hierarchy_id").getString()))
                    .With(HierarchyBenefitFeed::setTemporalFrequency, new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()))
                    .With(HierarchyBenefitFeed::setAmount, dbRow.column("hbf_amount").get(Double.class))
                    .With(HierarchyBenefitFeed::setStartedAt, dbRow.column("hbf_started_at").get(LocalDateTime.class))
                    .With(HierarchyBenefitFeed::setEndedAt, dbRow.column("hbf_ended_at").get(LocalDateTime.class))
                    .With(HierarchyBenefitFeed::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(HierarchyBenefitFeed::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(HierarchyBenefitFeed::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(HierarchyBenefitFeedNotificationFactory.FetchHierarchyBenefitFeedSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(HierarchyBenefitFeedNotificationFactory.FetchHierarchyBenefitFeedFail());
        }

        return builder.get();
    }
}
