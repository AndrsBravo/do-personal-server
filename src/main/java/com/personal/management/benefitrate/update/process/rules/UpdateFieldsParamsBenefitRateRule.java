package com.personal.management.benefitrate.update.process.rules;

import com.personal.management.benefitrate.update.process.UpdateBenefitRateProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsBenefitRateRule implements IProcessRule<UpdateBenefitRateProcess> {

    @Override
    public void apply(UpdateBenefitRateProcess process) {

        var pLogger = LogFactory.builder(UpdateBenefitRateProcess.class, UpdateFieldsParamsBenefitRateRule.class);

        var query = process.Query();

        var benefitRate = process.getInitObject();

        query.Field("id", benefitRate.getId());
        query.Where().Equ("id");

        query.Field("country_id", benefitRate.getCountry().getId());
        query.Where().AndEqu("country_id");

        if (benefitRate.getBenefit() != null) {
            query.Set("business_benefit_id", benefitRate.getBenefit().getId());
        }
        if (benefitRate.getTemporalFrequency() != null) {
            query.Set("temporal_frequency_id", benefitRate.getTemporalFrequency().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
