package com.personal.management.orgstructure.filter.process.rules;

import com.personal.management.orgstructure.factories.OrgStructureServiceFactory;
import com.personal.management.orgstructure.filter.process.FilterOrgStructureProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterOrgStructureRule implements IProcessRule<FilterOrgStructureProcess> {

    @Override
    public void apply(FilterOrgStructureProcess process) {

        var pLogger = LogFactory.builder(FilterOrgStructureProcess.class, FilterOrgStructureRule.class);
        var query = process.Query();
        var orgStructureFilter = process.getInitObject();
        if (orgStructureFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (orgStructureFilter.getId() != null) {
            query.Field("id", orgStructureFilter.getId());
            query.Where().AndEqu("id");
        }

        if (orgStructureFilter.getType() != null) {
            query.Field("orgs_structure", orgStructureFilter.getType());
            query.Where().AndEqu("orgs_structure");
        }

        var filterOrgStructure = OrgStructureServiceFactory.FilterOrgStructure();

        var result = filterOrgStructure.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
