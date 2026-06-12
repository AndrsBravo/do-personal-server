package com.personal.business.payrollrunresult.update.process.rules;

import com.personal.business.payrollrunresult.update.process.UpdatePayrollRunResultProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsPayrollRunResultRule implements IProcessRule<UpdatePayrollRunResultProcess> {

    @Override
    public void apply(UpdatePayrollRunResultProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollRunResultProcess.class, UpdateFieldsParamsPayrollRunResultRule.class);

        var query = process.Query();

        var payrollRunResult = process.getInitObject();

        query.Field("id", payrollRunResult.getId());
        query.Where().AndEqu("id");

        if (payrollRunResult.getPayroll() != null) {
            query.Set("payrolls_id", payrollRunResult.getPayroll().getId());
        }
        if (payrollRunResult.getBusiness() != null) {
            query.Set("business_id", payrollRunResult.getBusiness().getId());
        }
        if (payrollRunResult.getReference() != null) {
            query.Set("ref_id", payrollRunResult.getReference());
        }
        if (payrollRunResult.getReferenceTitle() != null) {
            query.Set("ref_title", payrollRunResult.getReferenceTitle());
        }
        if (payrollRunResult.getTitle() != null) {
            query.Set("prcr_title", payrollRunResult.getTitle());
        }
        if (payrollRunResult.getQuantity() != null) {
            query.Set("prcr_quantity", payrollRunResult.getQuantity().toString());
        }
        if (payrollRunResult.getDescription() != null) {
            query.Set("prcr_description", payrollRunResult.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
