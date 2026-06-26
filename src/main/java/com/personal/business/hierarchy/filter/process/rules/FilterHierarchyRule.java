package com.personal.business.hierarchy.filter.process.rules;

import com.personal.business.hierarchy.factories.HierarchyServiceFactory;
import com.personal.business.hierarchy.filter.process.FilterHierarchyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterHierarchyRule implements IProcessRule<FilterHierarchyProcess> {

    @Override
    public void apply(FilterHierarchyProcess process) {

        var pLogger = LogFactory.builder(FilterHierarchyProcess.class, FilterHierarchyRule.class);

        var query = process.Query();
        var hierarchyFilter = process.getInitObject();

        if (hierarchyFilter.getId() != null) {
            query.Field("id", hierarchyFilter.getId());
            query.Where().Field("id", hierarchyFilter.getId());
        }

        if (hierarchyFilter.getType() != null) {
            query.Field("bssh_hierarchy", hierarchyFilter.getType());
            query.Where().AndEqu("bssh_hierarchy");
        }

        var filterHierarchy = HierarchyServiceFactory.FilterHierarchy(hierarchyFilter.getBusiness().getDbName());

        var result = filterHierarchy.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
