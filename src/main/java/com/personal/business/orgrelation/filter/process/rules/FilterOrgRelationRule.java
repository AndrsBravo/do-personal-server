package com.personal.business.orgrelation.filter.process.rules;

import com.personal.business.orgrelation.factories.OrgRelationServiceFactory;
import com.personal.business.orgrelation.filter.process.FilterOrgRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterOrgRelationRule implements IProcessRule<FilterOrgRelationProcess> {

    @Override
    public void apply(FilterOrgRelationProcess process) {

        var pLogger = LogFactory.builder(FilterOrgRelationProcess.class, FilterOrgRelationRule.class);
        var query = process.Query();
        var orgRelationFilter = process.getInitObject();

        if (orgRelationFilter.getId() != null) {
            query.Field("id", orgRelationFilter.getId());
            query.Where().Field("id", orgRelationFilter.getId());
        }

        if (orgRelationFilter.getStructureId() != null) {
            query.Field("organization_structure", orgRelationFilter.getStructureId());
            query.Where().AndEqu("organization_structure");
        }

        if (orgRelationFilter.getHierarchyId() != null) {
            query.Field("organization_hierarchy", orgRelationFilter.getHierarchyId());
            query.Where().AndEqu("organization_hierarchy");
        }

        var filterOrgRelation = OrgRelationServiceFactory.FilterOrgRelation(orgRelationFilter.getBusiness().getDbName());

        var result = filterOrgRelation.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
