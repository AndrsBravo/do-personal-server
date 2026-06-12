package com.personal.business.hierarchydeduction.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.deduction.entities.Deduction;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.business.hierarchydeduction.factories.HierarchyDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterHierarchyDeductionService implements IFilterService<HierarchyDeduction> {

    private final Optional<DbClient> dbClient;

    public FilterHierarchyDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<HierarchyDeduction>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return HierarchyDeductionResultFactory.FetchNull();
        }

        var queryString = query.Select("hierarchies_deductions",
                "id", "business_id", "business_deductions_id", "business_hierarchy_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var hierarchyDeduction = new HierarchyDeduction();
                    hierarchyDeduction.setId(dbRow.column("id").getString());
                    hierarchyDeduction.setBusiness(new Business(dbRow.column("business_id").getString()));
                    hierarchyDeduction.setDeduction(new Deduction(dbRow.column("business_deductions_id").getString()));
                    hierarchyDeduction.setHierarchy(new Hierarchy(dbRow.column("business_hierarchy_id").getString()));
                    hierarchyDeduction.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    hierarchyDeduction.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    hierarchyDeduction.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return hierarchyDeduction;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return HierarchyDeductionResultFactory.FetchNull();
        }

        return HierarchyDeductionResultFactory.FetchResult(result);
    }
}
