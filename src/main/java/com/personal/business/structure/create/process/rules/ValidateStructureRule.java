package com.personal.business.structure.create.process.rules;

import com.personal.business.structure.create.process.CreateStructureProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateStructureRule implements IProcessRule<CreateStructureProcess> {

    @Override
    public void apply(CreateStructureProcess process) {

        var pLogger = LogFactory.builder(CreateStructureProcess.class, ValidateStructureRule.class);
        var query = process.Query();

        var structure = process.getInitObject();
        query.Field("id", structure.getId());
        query.Field("bss_title", structure.getTitle());
        query.Field("bss_structure", structure.getStructure());
        query.Field("bss_description", structure.getDescription());
        query.Field("created_at", structure.getCreatedAt().toString());
        query.Field("updated_at", structure.getUpdatedAt().toString());
        query.Field("created_by", structure.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
