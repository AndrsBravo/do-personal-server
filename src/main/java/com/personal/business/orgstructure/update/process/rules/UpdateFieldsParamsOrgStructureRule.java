package com.personal.business.orgstructure.update.process.rules;

import com.personal.business.orgstructure.update.process.UpdateOrgStructureProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsOrgStructureRule implements IProcessRule<UpdateOrgStructureProcess> {

    @Override
    public void apply(UpdateOrgStructureProcess process) {

        var pLogger = LogFactory.builder(UpdateOrgStructureProcess.class, UpdateFieldsParamsOrgStructureRule.class);

        var query = process.Query();

        var orgStructure = process.getInitObject();

        query.Field("id", orgStructure.getId());
        query.Where().AndEqu("id");

        if (orgStructure.getStructure() != null) {
            query.Set("orgs_structure", orgStructure.getStructure());
        }
        if (orgStructure.getDescription() != null) {
            query.Set("orgs_description", orgStructure.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
