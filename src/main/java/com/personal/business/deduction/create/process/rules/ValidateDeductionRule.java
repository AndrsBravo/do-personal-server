package com.personal.business.deduction.create.process.rules;

import com.personal.business.deduction.create.process.CreateDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateDeductionRule implements IProcessRule<CreateDeductionProcess> {

    @Override
    public void apply(CreateDeductionProcess process) {

        var pLogger = LogFactory.builder(CreateDeductionProcess.class, ValidateDeductionRule.class);
        var query = process.Query();

        var deduction = process.getInitObject();
        query.Field("id", deduction.getId());
        query.Field("bd_title", deduction.getTitle());
        query.Field("business_id", deduction.getBusiness().getId());
        query.Field("bd_deduction", deduction.getDeduction());
        query.Field("bd_description", deduction.getDescription());
        query.Field("created_at", deduction.getCreatedAt().toString());
        query.Field("updated_at", deduction.getUpdatedAt().toString());
        query.Field("created_by", deduction.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
