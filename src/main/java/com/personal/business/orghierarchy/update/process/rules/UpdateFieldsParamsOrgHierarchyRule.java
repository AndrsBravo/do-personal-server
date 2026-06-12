package com.personal.business.orghierarchy.update.process.rules;

import com.personal.business.orghierarchy.update.process.UpdateOrgHierarchyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsOrgHierarchyRule implements IProcessRule<UpdateOrgHierarchyProcess> {

    @Override
    public void apply(UpdateOrgHierarchyProcess process) {

        var pLogger = LogFactory.builder(UpdateOrgHierarchyProcess.class, UpdateFieldsParamsOrgHierarchyRule.class);

        var query = process.Query();

        var orgHierarchy = process.getInitObject();

        query.Field("id", orgHierarchy.getId());
        query.Where().AndEqu("id");

        if (orgHierarchy.getHierarchy() != null) {
            query.Set("orgh_hierarchy", orgHierarchy.getHierarchy());
        }
        if (orgHierarchy.getDescription() != null) {
            query.Set("orgh_description", orgHierarchy.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
