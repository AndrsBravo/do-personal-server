package com.personal.backoffice.userrelation.filter.process.rules;

import com.personal.backoffice.userrelation.factories.UserRelationServiceFactory;
import com.personal.backoffice.userrelation.filter.process.FilterUserRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterUserRelationRule implements IProcessRule<FilterUserRelationProcess> {

    @Override
    public void apply(FilterUserRelationProcess process) {

        var pLogger = LogFactory.builder(FilterUserRelationProcess.class, FilterUserRelationRule.class);
        var query = process.Query();
        var userRelationFilter = process.getInitObject();

        if (userRelationFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (userRelationFilter.getId() != null) {
            query.Field("id", userRelationFilter.getId());
            query.Where().AndEqu("id");
        }

        if (userRelationFilter.getType() != null) {
            query.Field("ur_relation", userRelationFilter.getType());
            query.Where().AndEqu("ur_relation");
        }

        var filterUserRelation = UserRelationServiceFactory.FilterUserRelations();

        var result = filterUserRelation.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
