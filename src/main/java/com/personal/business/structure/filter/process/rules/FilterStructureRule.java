package com.personal.business.structure.filter.process.rules;

import com.personal.business.structure.factories.StructureServiceFactory;
import com.personal.business.structure.filter.process.FilterStructureProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterStructureRule implements IProcessRule<FilterStructureProcess> {

    @Override
    public void apply(FilterStructureProcess process) {

        var pLogger = LogFactory.builder(FilterStructureProcess.class, FilterStructureRule.class);
        var query = process.Query();

        var structureFilterInput = process.getInitObject();

        if (structureFilterInput.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (structureFilterInput.getId() != null) {
            query.Field("id", structureFilterInput.getId());
            query.Where().AndEqu("id");
        }

        if (structureFilterInput.getType() != null) {
            query.Field("bss_structure", structureFilterInput.getType());
            query.Where().AndEqu("bss_structure");
        }

        var filterStructure = StructureServiceFactory.FilterStructure(structureFilterInput.getBusiness().getDbName());

        var result = filterStructure.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
