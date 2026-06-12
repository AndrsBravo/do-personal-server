package com.personal.business.hierarchy.create.process.rules;

import com.personal.business.hierarchy.create.process.CreateHierarchyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateHierarchyRule implements IProcessRule<CreateHierarchyProcess> {

    @Override
    public void apply(CreateHierarchyProcess process) {

        var pLogger = LogFactory.builder(CreateHierarchyProcess.class, ValidateHierarchyRule.class);
        var query = process.Query();

        var hierarchy = process.getInitObject();
        query.Field("id", hierarchy.getId());
        query.Field("bssh_title", hierarchy.getTitle());
        query.Field("bssh_hierarchy", hierarchy.getHierarchy());
        query.Field("bssh_description", hierarchy.getDescription());
        query.Field("created_at", hierarchy.getCreatedAt().toString());
        query.Field("updated_at", hierarchy.getUpdatedAt().toString());
        query.Field("created_by", hierarchy.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
