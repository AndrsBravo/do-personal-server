package com.personal.business.employeedeductionfeed.create.process.rules;

import com.personal.business.employeedeductionfeed.create.process.CreateEmployeeDeductionFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateEmployeeDeductionFeedRule implements IProcessRule<CreateEmployeeDeductionFeedProcess> {

    @Override
    public void apply(CreateEmployeeDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeDeductionFeedProcess.class, ValidateEmployeeDeductionFeedRule.class);
        var query = process.Query();

        var employeeDeductionFeed = process.getInitObject();
        query.Field("id", employeeDeductionFeed.getId());
        query.Field("business_id", employeeDeductionFeed.getBusiness().getId());
        query.Field("employee_id", employeeDeductionFeed.getEmployee().getId());
        query.Field("employee_deduction_id", employeeDeductionFeed.getEmployeeDeduction().getId());
        query.Field("business_deductions_id", employeeDeductionFeed.getDeduction().getId());
        query.Field("temporal_frequency_id", employeeDeductionFeed.getTemporalFrequency().getId());
        query.Field("ebf_amount", employeeDeductionFeed.getAmount().toString());
        query.Field("ebf_started_at", employeeDeductionFeed.getStartedAt().toString());
        query.Field("ebf_ended_at", employeeDeductionFeed.getEndedAt().toString());
        query.Field("created_at", employeeDeductionFeed.getCreatedAt().toString());
        query.Field("updated_at", employeeDeductionFeed.getUpdatedAt().toString());
        query.Field("created_by", employeeDeductionFeed.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
