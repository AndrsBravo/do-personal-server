package com.personal.management.orgrelation.update.process.rules;

import com.personal.management.orgrelation.update.process.UpdateOrgRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsOrgRelationRule implements IProcessRule<UpdateOrgRelationProcess> {

    @Override
    public void apply(UpdateOrgRelationProcess process) {

        var pLogger = LogFactory.builder(UpdateOrgRelationProcess.class, UpdateFieldsParamsOrgRelationRule.class);

        var query = process.Query();

        var orgRelation = process.getInitObject();

        query.Field("id", orgRelation.getId());
        query.Where().AndEqu("id");

        if (orgRelation.getStructure() != null) {
            query.Set("organization_structure", orgRelation.getStructure().getId());
        }
        if (orgRelation.getHierarchy() != null) {
            query.Set("organization_hierarchy", orgRelation.getHierarchy().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
