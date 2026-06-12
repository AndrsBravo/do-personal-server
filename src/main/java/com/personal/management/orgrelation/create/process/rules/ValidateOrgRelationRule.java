package com.personal.management.orgrelation.create.process.rules;

import com.personal.management.orgrelation.create.process.CreateOrgRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateOrgRelationRule implements IProcessRule<CreateOrgRelationProcess> {

    @Override
    public void apply(CreateOrgRelationProcess process) {

        var pLogger = LogFactory.builder(CreateOrgRelationProcess.class, ValidateOrgRelationRule.class);
        var query = process.Query();

        var orgRelation = process.getInitObject();
        query.Field("id", orgRelation.getId());
        query.Field("organization_hierarchy", orgRelation.getHierarchy().getId());
        query.Field("organization_structure", orgRelation.getStructure().getId());
        query.Field("created_at", orgRelation.getCreatedAt().toString());
        query.Field("updated_at", orgRelation.getUpdatedAt().toString());
        query.Field("created_by", orgRelation.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
