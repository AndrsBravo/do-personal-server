package com.personal.backoffice.country.create.process.rules;

import com.personal.backoffice.country.create.process.CreateCountryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateCountryRule implements IProcessRule<CreateCountryProcess> {

    @Override
    public void apply(CreateCountryProcess process) {

        var pLogger = LogFactory.builder(CreateCountryProcess.class, ValidateCountryRule.class);
        var query = process.Query();
        var country = process.getInitObject();
        query.Field("id", country.getId());
        query.Field("oc_code", country.getCode());
        query.Field("oc_name", country.getName());
        query.Field("oc_created_at", country.getCreatedAt().toString());
        query.Field("oc_updated_at", country.getUpdatedAt().toString());
        query.Field("oc_created_by", country.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
