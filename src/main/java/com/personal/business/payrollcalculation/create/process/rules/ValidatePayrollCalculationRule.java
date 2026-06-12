package com.personal.business.payrollcalculation.create.process.rules;

import com.personal.business.payrollcalculation.create.process.CreatePayrollCalculationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidatePayrollCalculationRule implements IProcessRule<CreatePayrollCalculationProcess> {

    @Override
    public void apply(CreatePayrollCalculationProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollCalculationProcess.class, ValidatePayrollCalculationRule.class);
        var query = process.Query();

        var payrollCalculation = process.getInitObject();
        query.Field("id", payrollCalculation.getId());
        query.Field("business_id", payrollCalculation.getBusiness().getId());
        query.Field("payrolls_id", payrollCalculation.getPayroll().getId());
        query.Field("prc_title", payrollCalculation.getTitle());
        query.Field("prc_description", payrollCalculation.getDescription());
        query.Field("created_at", payrollCalculation.getCreatedAt().toString());
        query.Field("updated_at", payrollCalculation.getUpdatedAt().toString());
        query.Field("created_by", payrollCalculation.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
