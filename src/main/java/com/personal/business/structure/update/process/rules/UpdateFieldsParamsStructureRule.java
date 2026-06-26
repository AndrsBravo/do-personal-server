package com.personal.business.structure.update.process.rules;

import com.personal.business.structure.update.process.UpdateStructureProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsStructureRule implements IProcessRule<UpdateStructureProcess> {

    @Override
    public void apply(UpdateStructureProcess process) {

        var pLogger = LogFactory.builder(UpdateStructureProcess.class, UpdateFieldsParamsStructureRule.class);

        var query = process.Query();

        var structure = process.getInitObject();

        query.Field("id", structure.getId());
        query.Where().Equ("id");

        if (structure.getStructure() != null) {
            query.Set("bss_structure", structure.getStructure());
        }
        if (structure.getDescription() != null) {
            query.Set("bss_description", structure.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
