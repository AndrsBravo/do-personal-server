package com.personal.business.hierarchydeductionfeed.filter.process.rules;

import com.personal.business.hierarchydeductionfeed.factories.HierarchyDeductionFeedServiceFactory;
import com.personal.business.hierarchydeductionfeed.filter.process.FilterHierarchyDeductionFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterHierarchyDeductionFeedRule implements IProcessRule<FilterHierarchyDeductionFeedProcess> {

    @Override
    public void apply(FilterHierarchyDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(FilterHierarchyDeductionFeedProcess.class, FilterHierarchyDeductionFeedRule.class);
        var query = process.Query();
        var hierarchyDeductionFeedFilter = process.getInitObject();
        if (hierarchyDeductionFeedFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (hierarchyDeductionFeedFilter.getId() != null) {
            query.Field("id", hierarchyDeductionFeedFilter.getId());
            query.Where().AndEqu("id");
        }

        if (hierarchyDeductionFeedFilter.getDeductionId() != null) {
            query.Field("business_deductions_id", hierarchyDeductionFeedFilter.getDeductionId());
            query.Where().AndEqu("business_deductions_id");
        }

        if (hierarchyDeductionFeedFilter.getHierarchyId() != null) {
            query.Field("business_hierarchy_id", hierarchyDeductionFeedFilter.getHierarchyId());
            query.Where().AndEqu("business_hierarchy_id");
        }

        var filterHierarchyDeductionFeed = HierarchyDeductionFeedServiceFactory.FilterHierarchyDeductionFeed(hierarchyDeductionFeedFilter.getBusiness().getDbName());

        var result = filterHierarchyDeductionFeed.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
