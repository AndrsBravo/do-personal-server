package com.personal.business.orgstructure.filter.process.rules;

import com.personal.business.orgstructure.factories.OrgStructureServiceFactory;
import com.personal.business.orgstructure.filter.process.FilterOrgStructureProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterOrgStructureRule implements IProcessRule<FilterOrgStructureProcess> {

    @Override
    public void apply(FilterOrgStructureProcess process) {

        var pLogger = LogFactory.builder(FilterOrgStructureProcess.class, FilterOrgStructureRule.class);

        var query = process.Query();
        var orgStructureFilter = process.getInitObject();

        if (orgStructureFilter.getId() != null) {
            query.Field("id", orgStructureFilter.getId());
            query.Where().Field("id", orgStructureFilter.getId());
        }

        if (orgStructureFilter.getStructure() != null) {
            query.Field("orgs_structure", orgStructureFilter.getStructure());
            query.Where().AndEqu("orgs_structure");
        }

        var filterOrgStructure = OrgStructureServiceFactory.FilterOrgStructure(orgStructureFilter.getBusiness().getDbName());

        var result = filterOrgStructure.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
