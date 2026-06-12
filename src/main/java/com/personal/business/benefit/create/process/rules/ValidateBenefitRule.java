package com.personal.business.benefit.create.process.rules;

import com.personal.business.benefit.create.process.CreateBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateBenefitRule implements IProcessRule<CreateBenefitProcess> {

    @Override
    public void apply(CreateBenefitProcess process) {

        var pLogger = LogFactory.builder(CreateBenefitProcess.class, ValidateBenefitRule.class);
        var query = process.Query();

        var benefit = process.getInitObject();
        query.Field("id", benefit.getId());
        query.Field("bb_title", benefit.getTitle());
        query.Field("bb_benefit", benefit.getBenefit());
        query.Field("bb_description", benefit.getDescription());
        query.Field("created_at", benefit.getCreatedAt().toString());
        query.Field("updated_at", benefit.getUpdatedAt().toString());
        query.Field("created_by", benefit.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
