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

        if (orgHierarchyFilter.getId() != null) {
            query.Field("id", orgHierarchyFilter.getId());
            query.Where().Field("id", orgHierarchyFilter.getId());
        }

        if (orgHierarchyFilter.getLevel() != 0) {
            query.Field("orgh_level", Short.toString(orgHierarchyFilter.getLevel()));
            query.Where().AndEqu("orgh_level");
        }

        if (orgHierarchyFilter.getTitle() != null) {
            query.Field("orgh_title", orgHierarchyFilter.getTitle());
            query.Where().AndEqu("orgh_title");
        }

        if (orgHierarchyFilter.getHierarchy() != null) {
            query.Field("orgh_hierarchy", orgHierarchyFilter.getHierarchy());
            query.Where().AndEqu("orgh_hierarchy");
        }

        var filterOrgHierarchy = OrgHierarchyServiceFactory.FilterOrgHierarchy(orgHierarchyFilter.getBusiness().getDbName());

        var result = filterOrgHierarchy.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filtrar Jerarquía", "Jerarquías filtradas con las propiedades: " + query.getKeyPair()));
    }

}
