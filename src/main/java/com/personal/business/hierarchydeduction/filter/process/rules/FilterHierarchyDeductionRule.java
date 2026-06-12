package com.personal.business.hierarchydeduction.filter.process.rules;

import com.personal.business.hierarchydeduction.factories.HierarchyDeductionServiceFactory;
import com.personal.business.hierarchydeduction.filter.process.FilterHierarchyDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterHierarchyDeductionRule implements IProcessRule<FilterHierarchyDeductionProcess> {

    @Override
    public void apply(FilterHierarchyDeductionProcess process) {

        var pLogger = LogFactory.builder(FilterHierarchyDeductionProcess.class, FilterHierarchyDeductionRule.class);
        var query = process.Query();
        var hierarchyDeductionFilter = process.getInitObject();
        if (hierarchyDeductionFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (hierarchyDeductionFilter.getId() != null) {
            query.Field("id", hierarchyDeductionFilter.getId());
            query.Where().AndEqu("id");
        }

        if (hierarchyDeductionFilter.getDeductionId() != null) {
            query.Field("business_deductions_id", hierarchyDeductionFilter.getDeductionId());
            query.Where().AndEqu("business_deductions_id");
        }

        if (hierarchyDeductionFilter.getHierarchyId() != null) {
            query.Field("business_hierarchy_id", hierarchyDeductionFilter.getHierarchyId());
            query.Where().AndEqu("business_hierarchy_id");
        }

        var filterHierarchyDeduction = HierarchyDeductionServiceFactory.FilterHierarchyDeduction(hierarchyDeductionFilter.getBusiness().getDbName());

        var result = filterHierarchyDeduction.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
