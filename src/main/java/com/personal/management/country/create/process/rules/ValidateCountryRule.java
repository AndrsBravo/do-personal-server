package com.personal.management.country.create.process.rules;

import com.personal.management.country.create.process.CreateCountryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateCountryRule implements IProcessRule<CreateCountryProcess> {

    @Override
    public void apply(CreateCountryProcess process) {

        var pLogger = LogFactory.builder(CreateCountryProcess.class, ValidateCountryRule.class);
        var query = process.Query();

        var country = process.getInitObject();
        query.Field("id", country.getId());
        //  query.Field("co_code", country.getCode());
        //  query.Field("co_name", country.getName());
        query.Field("co_created_at", country.getCreatedAt().toString());
        query.Field("co_updated_at", country.getUpdatedAt().toString());
        query.Field("co_created_by", country.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo País en Management", "País management validado con éxito"));

    }

}
