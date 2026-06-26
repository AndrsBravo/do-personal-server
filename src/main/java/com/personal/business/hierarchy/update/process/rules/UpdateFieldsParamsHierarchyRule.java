package com.personal.business.hierarchy.update.process.rules;

import com.personal.business.hierarchy.update.process.UpdateHierarchyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsHierarchyRule implements IProcessRule<UpdateHierarchyProcess> {

    @Override
    public void apply(UpdateHierarchyProcess process) {

        var pLogger = LogFactory.builder(UpdateHierarchyProcess.class, UpdateFieldsParamsHierarchyRule.class);

        var query = process.Query();

        var hierarchy = process.getInitObject();

        query.Field("id", hierarchy.getId());
        query.Where().Equ("id");

        if (hierarchy.getHierarchy() != null) {
            query.Set("bssh_hierarchy", hierarchy.getHierarchy());
        }
        if (hierarchy.getDescription() != null) {
            query.Set("bssh_description", hierarchy.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
