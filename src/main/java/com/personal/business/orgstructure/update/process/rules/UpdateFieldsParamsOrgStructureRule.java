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
        query.Where().Equ("id");

        if (orgStructure.getTitle() != null) {
            query.Set("orgs_title", orgStructure.getTitle());
        }
        if (orgStructure.getLevel() != 0) {
            query.Set("orgs_level", Short.toString(orgStructure.getLevel()));
        }
        if (orgStructure.getStructure() != null) {
            query.Set("orgs_structure", orgStructure.getStructure());
        }
        if (orgStructure.getDescription() != null) {
            query.Set("orgs_description", orgStructure.getDescription());
        }
        process.addLog(pLogger.INFO("Validar nueva Estructura de Organización", "Los campos de la Estructura fueron validados exitosamente."));

    }
}
