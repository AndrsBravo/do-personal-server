package com.personal.business.orgstructure.create.process.rules;

import com.personal.business.orgstructure.create.process.CreateOrgStructureProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateOrgStructureRule implements IProcessRule<CreateOrgStructureProcess> {

    @Override
    public void apply(CreateOrgStructureProcess process) {

        var pLogger = LogFactory.builder(CreateOrgStructureProcess.class, ValidateOrgStructureRule.class);
        var query = process.Query();

        var orgStructure = process.getInitObject();
        query.Field("id", orgStructure.getId());
        query.Field("orgs_title", orgStructure.getTitle());
        query.Field("orgs_structure", orgStructure.getStructure());
        query.Field("orgs_description", orgStructure.getDescription());
        query.Field("created_at", orgStructure.getCreatedAt().toString());
        query.Field("updated_at", orgStructure.getUpdatedAt().toString());
        query.Field("created_by", orgStructure.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
