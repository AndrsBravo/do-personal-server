package com.personal.business.hierarchybenefitfeed.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.benefit.entities.Benefit;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;
import com.personal.business.hierarchybenefitfeed.factories.HierarchyBenefitFeedResultFactory;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterHierarchyBenefitFeedService implements IFilterService<HierarchyBenefitFeed> {

    private final Optional<DbClient> dbClient;

    public FilterHierarchyBenefitFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<HierarchyBenefitFeed>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return HierarchyBenefitFeedResultFactory.FetchNull();
        }

        var queryString = query.Select("hierarchies_benefits_feeds",
                "id", "business_id", "business_benefits_id", "business_hierarchy_id", "temporal_frequency_id", "hbf_amount", "hbf_started_at", "hbf_ended_at", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var hierarchyBenefitFeed = new HierarchyBenefitFeed();
                    hierarchyBenefitFeed.setId(dbRow.column("id").getString());
                    hierarchyBenefitFeed.setBusiness(new Business(dbRow.column("business_id").getString()));
                    hierarchyBenefitFeed.setBenefit(new Benefit(dbRow.column("business_benefits_id").getString()));
                    hierarchyBenefitFeed.setHierarchy(new Hierarchy(dbRow.column("business_hierarchy_id").getString()));
                    hierarchyBenefitFeed.setTemporalFrequency(new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()));
                    hierarchyBenefitFeed.setAmount(dbRow.column("hbf_amount").get(Double.class));
                    hierarchyBenefitFeed.setStartedAt(dbRow.column("hbf_started_at").get(LocalDateTime.class));
                    hierarchyBenefitFeed.setEndedAt(dbRow.column("hbf_ended_at").get(LocalDateTime.class));
                    hierarchyBenefitFeed.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    hierarchyBenefitFeed.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    hierarchyBenefitFeed.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return hierarchyBenefitFeed;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return HierarchyBenefitFeedResultFactory.FetchNull();
        }

        return HierarchyBenefitFeedResultFactory.FetchResult(result);
    }
}
