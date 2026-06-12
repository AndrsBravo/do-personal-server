package com.personal.management.deductionrate.create.process.rules;

import com.personal.management.deductionrate.create.process.CreateDeductionRateProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateDeductionRateRule implements IProcessRule<CreateDeductionRateProcess> {

    @Override
    public void apply(CreateDeductionRateProcess process) {

        var pLogger = LogFactory.builder(CreateDeductionRateProcess.class, ValidateDeductionRateRule.class);
        var query = process.Query();

        var deductionRate = process.getInitObject();
        query.Field("id", deductionRate.getId());
        query.Field("country_id", deductionRate.getCountry().getId());
        query.Field("business_deduction_id", deductionRate.getDeduction().getId());
        query.Field("temporal_frequency_id", deductionRate.getTemporalFrequency().getId());
        query.Field("bdr_amount", deductionRate.getAmount().toString());
        query.Field("bdr_rate", deductionRate.getRate().toString());
        query.Field("bdr_base_amount", deductionRate.getBaseAmount().toString());
        query.Field("bdr_level", deductionRate.getLevel().toString());
        query.Field("bdr_started_at", deductionRate.getStartedAt().toString());
        query.Field("bdr_ends_at", deductionRate.getEndedAt().toString());
        query.Field("created_at", deductionRate.getCreatedAt().toString());
        query.Field("updated_at", deductionRate.getUpdatedAt().toString());
        query.Field("created_by", deductionRate.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
