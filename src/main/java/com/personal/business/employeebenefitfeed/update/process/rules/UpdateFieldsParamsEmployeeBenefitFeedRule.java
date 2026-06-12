package com.personal.business.employeebenefitfeed.update.process.rules;

import com.personal.business.employeebenefitfeed.update.process.UpdateEmployeeBenefitFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsEmployeeBenefitFeedRule implements IProcessRule<UpdateEmployeeBenefitFeedProcess> {

    @Override
    public void apply(UpdateEmployeeBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeBenefitFeedProcess.class, UpdateFieldsParamsEmployeeBenefitFeedRule.class);

        var query = process.Query();

        var employeeBenefitFeed = process.getInitObject();

        query.Field("id", employeeBenefitFeed.getId());
        query.Where().AndEqu("id");

        if (employeeBenefitFeed.getBusiness() != null) {
            query.Set("business_id", employeeBenefitFeed.getBusiness().getId());
        }

        if (employeeBenefitFeed.getBenefit() != null) {
            query.Set("business_benefits_id", employeeBenefitFeed.getBenefit().getId());
        }
        if (employeeBenefitFeed.getEmployee() != null) {
            query.Set("employee_benefit_id", employeeBenefitFeed.getEmployee().getId());
        }
        if (employeeBenefitFeed.getTemporalFrequency() != null) {
            query.Set("temporal_frequency_id", employeeBenefitFeed.getTemporalFrequency().getId());
        }
        if (employeeBenefitFeed.getAmount() != null) {
            query.Set("ebf_amount", employeeBenefitFeed.getAmount().toString());
        }
        if (employeeBenefitFeed.getStartedAt() != null) {
            query.Set("ebf_started_at", employeeBenefitFeed.getStartedAt().toString());
        }
        if (employeeBenefitFeed.getEndedAt() != null) {
            query.Set("ebf_ended_at", employeeBenefitFeed.getEndedAt().toString());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
