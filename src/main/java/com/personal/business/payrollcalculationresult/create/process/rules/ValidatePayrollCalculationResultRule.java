package com.personal.business.payrollcalculationresult.create.process.rules;

import com.personal.business.payrollcalculationresult.create.process.CreatePayrollCalculationResultProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidatePayrollCalculationResultRule implements IProcessRule<CreatePayrollCalculationResultProcess> {

    @Override
    public void apply(CreatePayrollCalculationResultProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollCalculationResultProcess.class, ValidatePayrollCalculationResultRule.class);
        var query = process.Query();

        var payrollCalculationResult = process.getInitObject();
        query.Field("id", payrollCalculationResult.getId());
        query.Field("business_id", payrollCalculationResult.getBusiness().getId());
        query.Field("payrolls_id", payrollCalculationResult.getPayroll().getId());
        query.Field("prcr_title", payrollCalculationResult.getTitle());
        query.Field("prcr_description", payrollCalculationResult.getDescription());
        query.Field("created_at", payrollCalculationResult.getCreatedAt().toString());
        query.Field("updated_at", payrollCalculationResult.getUpdatedAt().toString());
        query.Field("created_by", payrollCalculationResult.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
