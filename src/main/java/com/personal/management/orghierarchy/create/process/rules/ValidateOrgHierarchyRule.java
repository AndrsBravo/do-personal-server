package com.personal.management.orghierarchy.create.process.rules;

import com.personal.management.orghierarchy.create.process.CreateOrgHierarchyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateOrgHierarchyRule implements IProcessRule<CreateOrgHierarchyProcess> {

    @Override
    public void apply(CreateOrgHierarchyProcess process) {

        var pLogger = LogFactory.builder(CreateOrgHierarchyProcess.class, ValidateOrgHierarchyRule.class);
        var query = process.Query();

        var orgHierarchy = process.getInitObject();
        query.Field("id", orgHierarchy.getId());
        query.Field("country_id", orgHierarchy.getCountry().getId());
        query.Field("orgh_level", Short.toString(orgHierarchy.getLevel()));
        query.Field("orgh_title", orgHierarchy.getTitle());
        query.Field("orgh_hierarchy", orgHierarchy.getHierarchy());
        query.Field("orgh_description", orgHierarchy.getDescription());
        query.Field("created_at", orgHierarchy.getCreatedAt().toString());
        query.Field("updated_at", orgHierarchy.getUpdatedAt().toString());
        query.Field("created_by", orgHierarchy.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Validar nueva Jerarquía", "La Jerarquía ha sido validada con éxito"));

    }

}
