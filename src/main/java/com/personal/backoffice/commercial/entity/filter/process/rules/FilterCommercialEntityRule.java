package com.personal.backoffice.commercial.entity.filter.process.rules;

import com.personal.backoffice.commercial.entity.factories.CommercialEntityServiceFactory;
import com.personal.backoffice.commercial.entity.filter.process.FilterCommercialEntityProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterCommercialEntityRule implements IProcessRule<FilterCommercialEntityProcess> {

    @Override
    public void apply(FilterCommercialEntityProcess process) {

        var pLogger = LogFactory.builder(FilterCommercialEntityProcess.class, FilterCommercialEntityRule.class);
        var query = process.Query();
        var commercialEntityFilter = process.getInitObject();

        if (commercialEntityFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (commercialEntityFilter.getId() != null) {
            query.Field("id", commercialEntityFilter.getId());
            query.Where().AndEqu("id");
        }

        if (commercialEntityFilter.getType() != null) {
            query.Field("ce_entity", commercialEntityFilter.getType());
            query.Where().AndEqu("ce_entity");
        }

        var filterCommercialEntity = CommercialEntityServiceFactory.FilterCommercialEntity();

        var result = filterCommercialEntity.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
