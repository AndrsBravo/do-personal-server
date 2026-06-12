package com.personal.management.benefitrate.create.process.rules;

import com.personal.management.benefitrate.create.process.CreateBenefitRateProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateBenefitRateRule implements IProcessRule<CreateBenefitRateProcess> {

    @Override
    public void apply(CreateBenefitRateProcess process) {

        var pLogger = LogFactory.builder(CreateBenefitRateProcess.class, ValidateBenefitRateRule.class);
        var query = process.Query();

        var benefitRate = process.getInitObject();
        query.Field("id", benefitRate.getId());
        query.Field("country_id", benefitRate.getCountry().getId());
        query.Field("business_benefit_id", benefitRate.getBenefit().getId());
        query.Field("temporal_frequency_id", benefitRate.getTemporalFrequency().getId());
        query.Field("bbr_amount", benefitRate.getAmount().toString());
        query.Field("bbr_rate", benefitRate.getRate().toString());
        query.Field("bbr_base_amount", benefitRate.getBaseAmount().toString());
        query.Field("bbr_level", benefitRate.getLevel().toString());
        query.Field("bbr_started_at", benefitRate.getStartedAt().toString());
        query.Field("bbr_ends_at", benefitRate.getEndedAt().toString());
        query.Field("created_at", benefitRate.getCreatedAt().toString());
        query.Field("updated_at", benefitRate.getUpdatedAt().toString());
        query.Field("created_by", benefitRate.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
