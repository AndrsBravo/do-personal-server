package com.personal.business.hierarchybenefitfeed.filter.process.rules;

import com.personal.business.hierarchybenefitfeed.factories.HierarchyBenefitFeedServiceFactory;
import com.personal.business.hierarchybenefitfeed.filter.process.FilterHierarchyBenefitFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterHierarchyBenefitFeedRule implements IProcessRule<FilterHierarchyBenefitFeedProcess> {

    @Override
    public void apply(FilterHierarchyBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(FilterHierarchyBenefitFeedProcess.class, FilterHierarchyBenefitFeedRule.class);
        var query = process.Query();
        var hierarchyBenefitFeedFilter = process.getInitObject();
        if (hierarchyBenefitFeedFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (hierarchyBenefitFeedFilter.getId() != null) {
            query.Field("id", hierarchyBenefitFeedFilter.getId());
            query.Where().AndEqu("id");
        }

        if (hierarchyBenefitFeedFilter.getBenefitId() != null) {
            query.Field("business_benefits_id", hierarchyBenefitFeedFilter.getBenefitId());
            query.Where().AndEqu("business_benefits_id");
        }

        if (hierarchyBenefitFeedFilter.getHierarchyId() != null) {
            query.Field("business_hierarchy_id", hierarchyBenefitFeedFilter.getHierarchyId());
            query.Where().AndEqu("business_hierarchy_id");
        }

        var filterHierarchyBenefitFeed = HierarchyBenefitFeedServiceFactory.FilterHierarchyBenefitFeed(hierarchyBenefitFeedFilter.getBusiness().getDbName());

        var result = filterHierarchyBenefitFeed.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
