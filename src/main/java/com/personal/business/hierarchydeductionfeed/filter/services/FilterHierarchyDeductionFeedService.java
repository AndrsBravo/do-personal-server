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
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

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
                .map((dbRow) -> {
                    var hierarchyDeductionFeed = new HierarchyDeductionFeed();
                    hierarchyDeductionFeed.setId(dbRow.column("id").getString());
                    hierarchyDeductionFeed.setBusiness(new Business(dbRow.column("business_id").getString()));
                    hierarchyDeductionFeed.setDeduction(new Deduction(dbRow.column("business_deductions_id").getString()));
                    hierarchyDeductionFeed.setHierarchy(new Hierarchy(dbRow.column("business_hierarchy_id").getString()));
                    hierarchyDeductionFeed.setTemporalFrequency(new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()));
                    hierarchyDeductionFeed.setAmount(dbRow.column("hdf_amount").get(Double.class));
                    hierarchyDeductionFeed.setStartedAt(dbRow.column("hdf_started_at").get(LocalDateTime.class));
                    hierarchyDeductionFeed.setEndedAt(dbRow.column("hdf_ended_at").get(LocalDateTime.class));
                    hierarchyDeductionFeed.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    hierarchyDeductionFeed.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    hierarchyDeductionFeed.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return hierarchyDeductionFeed;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return HierarchyDeductionFeedResultFactory.FetchNull();
        }

        return HierarchyDeductionFeedResultFactory.FetchResult(result);
    }
}
