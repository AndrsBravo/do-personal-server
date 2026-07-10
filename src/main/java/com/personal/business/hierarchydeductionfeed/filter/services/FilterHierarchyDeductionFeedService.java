package com.personal.business.hierarchydeductionfeed.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.deduction.entities.Deduction;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;
import com.personal.business.hierarchydeductionfeed.factories.HierarchyDeductionFeedResultFactory;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterHierarchyDeductionFeedService implements IFilterService<HierarchyDeductionFeed> {

    private final Optional<DbClient> dbClient;

    public FilterHierarchyDeductionFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<HierarchyDeductionFeed>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return HierarchyDeductionFeedResultFactory.FetchNull();
        }

        var queryString = query.Select("hierarchies_deductions_feeds",
                "id", "business_id", "business_deductions_id", "business_hierarchy_id", "temporal_frequency_id", "hdf_amount", "hdf_started_at", "hdf_ended_at", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(HierarchyDeductionFeed::new)
                .With(HierarchyDeductionFeed::setId, dbRow.column("id").getString())
                .With(HierarchyDeductionFeed::setBusiness, new Business(dbRow.column("business_id").getString()))
                .With(HierarchyDeductionFeed::setDeduction, new Deduction(dbRow.column("business_deductions_id").getString()))
                .With(HierarchyDeductionFeed::setHierarchy, new Hierarchy(dbRow.column("business_hierarchy_id").getString()))
                .With(HierarchyDeductionFeed::setTemporalFrequency, new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()))
                .With(HierarchyDeductionFeed::setAmount, dbRow.column("hdf_amount").get(Double.class))
                .With(HierarchyDeductionFeed::setStartedAt, dbRow.column("hdf_started_at").get(LocalDateTime.class))
                .With(HierarchyDeductionFeed::setEndedAt, dbRow.column("hdf_ended_at").get(LocalDateTime.class))
                .With(HierarchyDeductionFeed::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(HierarchyDeductionFeed::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(HierarchyDeductionFeed::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return HierarchyDeductionFeedResultFactory.FetchNull();
        }

        return HierarchyDeductionFeedResultFactory.FetchResult(result);
    }
}
