package com.personal.business.employeedeductionfeed.update.process.rules;

import com.personal.business.employeedeductionfeed.update.process.UpdateEmployeeDeductionFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsEmployeeDeductionFeedRule implements IProcessRule<UpdateEmployeeDeductionFeedProcess> {

    @Override
    public void apply(UpdateEmployeeDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeDeductionFeedProcess.class, UpdateFieldsParamsEmployeeDeductionFeedRule.class);

        var query = process.Query();

        var employeeDeductionFeed = process.getInitObject();

        query.Field("id", employeeDeductionFeed.getId());
        query.Where().Equ("id");

        if (employeeDeductionFeed.getBusiness() != null) {
            query.Set("business_id", employeeDeductionFeed.getBusiness().getId());
        }

        if (employeeDeductionFeed.getDeduction() != null) {
            query.Set("business_deductions_id", employeeDeductionFeed.getDeduction().getId());
        }
        if (employeeDeductionFeed.getEmployee() != null) {
            query.Set("employee_deduction_id", employeeDeductionFeed.getEmployee().getId());
        }
        if (employeeDeductionFeed.getTemporalFrequency() != null) {
            query.Set("temporal_frequency_id", employeeDeductionFeed.getTemporalFrequency().getId());
        }
        if (employeeDeductionFeed.getAmount() != null) {
            query.Set("ebf_amount", employeeDeductionFeed.getAmount().toString());
        }
        if (employeeDeductionFeed.getStartedAt() != null) {
            query.Set("ebf_started_at", employeeDeductionFeed.getStartedAt().toString());
        }
        if (employeeDeductionFeed.getEndedAt() != null) {
            query.Set("ebf_ended_at", employeeDeductionFeed.getEndedAt().toString());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
