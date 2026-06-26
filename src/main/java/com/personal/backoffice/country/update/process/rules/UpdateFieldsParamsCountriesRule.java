package com.personal.backoffice.country.update.process.rules;

import com.personal.backoffice.country.update.process.UpdateCountryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsCountriesRule implements IProcessRule<UpdateCountryProcess> {

    @Override
    public void apply(UpdateCountryProcess process) {

        var pLogger = LogFactory.builder(UpdateCountryProcess.class, UpdateFieldsParamsCountriesRule.class);

        var query = process.Query();

        var country = process.getInitObject();

        query.Field("id", country.getId());
        query.Where().Equ("id");

        if (country.getCode() != null) {
            query.Set("co_code", country.getCode());
        }
        if (country.getName() != null) {
            query.Set("co_name", country.getName());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'name' son obligatorios"));

    }
}
