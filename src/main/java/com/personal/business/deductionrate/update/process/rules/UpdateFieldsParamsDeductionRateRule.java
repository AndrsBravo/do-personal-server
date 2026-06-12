package com.personal.business.deductionrate.update.process.rules;

import com.personal.business.deductionrate.update.process.UpdateDeductionRateProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsDeductionRateRule implements IProcessRule<UpdateDeductionRateProcess> {

    @Override
    public void apply(UpdateDeductionRateProcess process) {

        var pLogger = LogFactory.builder(UpdateDeductionRateProcess.class, UpdateFieldsParamsDeductionRateRule.class);

        var query = process.Query();

        var deductionRate = process.getInitObject();

        query.Field("id", deductionRate.getId());
        query.Where().AndEqu("id");

        query.Field("business_id", deductionRate.getBusiness().getId());
        query.Where().AndEqu("business_id");

        if (deductionRate.getDeduction() != null) {
            query.Set("business_deduction_id", deductionRate.getDeduction().getId());
        }
        if (deductionRate.getTemporalFrequency() != null) {
            query.Set("temporal_frequency_id", deductionRate.getTemporalFrequency().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
