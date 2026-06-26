package com.personal.business.hierarchybenefit.filter.process.rules;

import com.personal.business.hierarchybenefit.factories.HierarchyBenefitServiceFactory;
import com.personal.business.hierarchybenefit.filter.process.FilterHierarchyBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterHierarchyBenefitRule implements IProcessRule<FilterHierarchyBenefitProcess> {

    @Override
    public void apply(FilterHierarchyBenefitProcess process) {

        var pLogger = LogFactory.builder(FilterHierarchyBenefitProcess.class, FilterHierarchyBenefitRule.class);
        var query = process.Query();
        var hierarchyBenefitFilter = process.getInitObject();

        if (hierarchyBenefitFilter.getId() != null) {
            query.Field("id", hierarchyBenefitFilter.getId());
            query.Where().Field("id", hierarchyBenefitFilter.getId());
        }

        if (hierarchyBenefitFilter.getBenefitId() != null) {
            query.Field("business_benefits_id", hierarchyBenefitFilter.getBenefitId());
            query.Where().AndEqu("business_benefits_id");
        }

        if (hierarchyBenefitFilter.getHierarchyId() != null) {
            query.Field("business_hierarchy_id", hierarchyBenefitFilter.getHierarchyId());
            query.Where().AndEqu("business_hierarchy_id");
        }

        var filterHierarchyBenefit = HierarchyBenefitServiceFactory.FilterHierarchyBenefit(hierarchyBenefitFilter.getBusiness().getDbName());

        var result = filterHierarchyBenefit.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
