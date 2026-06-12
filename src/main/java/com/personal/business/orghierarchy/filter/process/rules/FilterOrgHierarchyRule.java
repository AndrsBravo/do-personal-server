package com.personal.business.orghierarchy.filter.process.rules;

import com.personal.business.orghierarchy.factories.OrgHierarchyServiceFactory;
import com.personal.business.orghierarchy.filter.process.FilterOrgHierarchyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterOrgHierarchyRule implements IProcessRule<FilterOrgHierarchyProcess> {

    @Override
    public void apply(FilterOrgHierarchyProcess process) {

        var pLogger = LogFactory.builder(FilterOrgHierarchyProcess.class, FilterOrgHierarchyRule.class);

        var query = process.Query();
        var orgHierarchyFilter = process.getInitObject();

        if (orgHierarchyFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (orgHierarchyFilter.getId() != null) {
            query.Field("id", orgHierarchyFilter.getId());
            query.Where().AndEqu("id");
        }

        if (orgHierarchyFilter.getType() != null) {
            query.Field("orgh_hierarchy", orgHierarchyFilter.getType());
            query.Where().AndEqu("orgh_hierarchy");
        }

        var filterOrgHierarchy = OrgHierarchyServiceFactory.FilterOrgHierarchy(orgHierarchyFilter.getBusiness().getDbName());

        var result = filterOrgHierarchy.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
