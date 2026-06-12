package com.personal.business.hierarchybenefit.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.benefit.entities.Benefit;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.business.hierarchybenefit.factories.HierarchyBenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterHierarchyBenefitService implements IFilterService<HierarchyBenefit> {

    private final Optional<DbClient> dbClient;

    public FilterHierarchyBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<HierarchyBenefit>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return HierarchyBenefitResultFactory.FetchNull();
        }

        var queryString = query.Select("hierarchies_benefits",
                "id", "business_id", "business_benefits_id", "business_hierarchy_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var hierarchyBenefit = new HierarchyBenefit();
                    hierarchyBenefit.setId(dbRow.column("id").getString());
                    hierarchyBenefit.setBusiness(new Business(dbRow.column("business_id").getString()));
                    hierarchyBenefit.setBenefit(new Benefit(dbRow.column("business_benefits_id").getString()));
                    hierarchyBenefit.setHierarchy(new Hierarchy(dbRow.column("business_hierarchy_id").getString()));
                    hierarchyBenefit.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    hierarchyBenefit.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    hierarchyBenefit.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return hierarchyBenefit;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return HierarchyBenefitResultFactory.FetchNull();
        }

        return HierarchyBenefitResultFactory.FetchResult(result);
    }
}
