package com.personal.business.employeebenefitfeed.create.process.rules;

import com.personal.business.employeebenefitfeed.create.process.CreateEmployeeBenefitFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateEmployeeBenefitFeedRule implements IProcessRule<CreateEmployeeBenefitFeedProcess> {

    @Override
    public void apply(CreateEmployeeBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeBenefitFeedProcess.class, ValidateEmployeeBenefitFeedRule.class);
        var query = process.Query();

        var employeeBenefitFeed = process.getInitObject();
        query.Field("id", employeeBenefitFeed.getId());
        query.Field("business_id", employeeBenefitFeed.getBusiness().getId());
        query.Field("employee_id", employeeBenefitFeed.getEmployee().getId());
        query.Field("employee_benefit_id", employeeBenefitFeed.getEmployeeBenefit().getId());
        query.Field("business_benefits_id", employeeBenefitFeed.getBenefit().getId());
        query.Field("temporal_frequency_id", employeeBenefitFeed.getTemporalFrequency().getId());
        query.Field("ebf_amount", employeeBenefitFeed.getAmount().toString());
        query.Field("ebf_started_at", employeeBenefitFeed.getStartedAt().toString());
        query.Field("ebf_ended_at", employeeBenefitFeed.getEndedAt().toString());
        query.Field("created_at", employeeBenefitFeed.getCreatedAt().toString());
        query.Field("updated_at", employeeBenefitFeed.getUpdatedAt().toString());
        query.Field("created_by", employeeBenefitFeed.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
