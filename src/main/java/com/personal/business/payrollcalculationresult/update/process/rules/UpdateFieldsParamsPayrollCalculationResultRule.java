package com.personal.business.payrollcalculationresult.update.process.rules;

import com.personal.business.payrollcalculationresult.update.process.UpdatePayrollCalculationResultProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsPayrollCalculationResultRule implements IProcessRule<UpdatePayrollCalculationResultProcess> {

    @Override
    public void apply(UpdatePayrollCalculationResultProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollCalculationResultProcess.class, UpdateFieldsParamsPayrollCalculationResultRule.class);

        var query = process.Query();

        var payrollCalculationResult = process.getInitObject();

        query.Field("id", payrollCalculationResult.getId());
        query.Where().AndEqu("id");

        if (payrollCalculationResult.getPayroll() != null) {
            query.Set("payrolls_id", payrollCalculationResult.getPayroll().getId());
        }
        if (payrollCalculationResult.getBusiness() != null) {
            query.Set("business_id", payrollCalculationResult.getBusiness().getId());
        }
        if (payrollCalculationResult.getReference() != null) {
            query.Set("ref_id", payrollCalculationResult.getReference());
        }
        if (payrollCalculationResult.getReferenceTitle() != null) {
            query.Set("ref_title", payrollCalculationResult.getReferenceTitle());
        }
        if (payrollCalculationResult.getTitle() != null) {
            query.Set("prcr_title", payrollCalculationResult.getTitle());
        }
        if (payrollCalculationResult.getQuantity() != null) {
            query.Set("prcr_quantity", payrollCalculationResult.getQuantity().toString());
        }
        if (payrollCalculationResult.getDescription() != null) {
            query.Set("prcr_description", payrollCalculationResult.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
