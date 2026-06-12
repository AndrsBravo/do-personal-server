package com.personal.backoffice.business.process.create.rules;

import com.personal.backoffice.business.process.create.CreateBusinessProcess;
import com.personal.backoffice.shared.utils.Utils;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateBusinessRule implements IProcessRule<CreateBusinessProcess> {

    @Override
    public void apply(CreateBusinessProcess process) {

        var pLogger = LogFactory.builder(CreateBusinessProcess.class, ValidateBusinessRule.class);
        var query = process.Query();
        var business = process.getInitObject();
        query.Field("id", business.getId());
        query.Field("client_id", business.getClient().getId());
        query.Field("country_id", business.getCountry().getId());
        query.Field("bss_name", business.getName());
        query.Field("bss_db_name", Utils.generateDatabaseName(business.getId()));
        query.Field("bss_created_at", business.getCreatedAt().toString());
        query.Field("bss_updated_at", business.getUpdatedAt().toString());
        query.Field("bss_created_by", business.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
