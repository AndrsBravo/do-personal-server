package com.personal.management.orghierarchy.update.process.rules;

import com.personal.management.orghierarchy.update.process.UpdateOrgHierarchyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsOrgHierarchyRule implements IProcessRule<UpdateOrgHierarchyProcess> {

    @Override
    public void apply(UpdateOrgHierarchyProcess process) {

        var pLogger = LogFactory.builder(UpdateOrgHierarchyProcess.class, UpdateFieldsParamsOrgHierarchyRule.class);

        var query = process.Query();

        var orgHierarchy = process.getInitObject();

        query.Field("id", orgHierarchy.getId());
        query.Where().Equ("id");

        if (orgHierarchy.getCountry() != null) {
            query.Set("country_id", orgHierarchy.getCountry().getId());
        }
        if (orgHierarchy.getLevel() != 0) {
            query.Set("orgh_level", Short.toString(orgHierarchy.getLevel()));
        }
        if (orgHierarchy.getHierarchy() != null) {
            query.Set("orgh_hierarchy", orgHierarchy.getHierarchy());
        }
        if (orgHierarchy.getTitle() != null) {
            query.Set("orgh_title", orgHierarchy.getTitle());
        }
        if (orgHierarchy.getDescription() != null) {
            query.Set("orgh_description", orgHierarchy.getDescription());
        }
        process.addLog(pLogger.INFO("Validar Jerarquía", "La Jerarquía ha sido validada con éxito"));

    }
}
