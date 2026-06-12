package com.personal.business.payrollcalculation.update.process.rules;

import com.personal.business.payrollcalculation.update.process.UpdatePayrollCalculationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsPayrollCalculationRule implements IProcessRule<UpdatePayrollCalculationProcess> {

    @Override
    public void apply(UpdatePayrollCalculationProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollCalculationProcess.class, UpdateFieldsParamsPayrollCalculationRule.class);

        var query = process.Query();

        var payrollCalculation = process.getInitObject();

        query.Field("id", payrollCalculation.getId());
        query.Where().AndEqu("id");

        if (payrollCalculation.getPayroll() != null) {
            query.Set("payrolls_id", payrollCalculation.getPayroll().getId());
        }
        if (payrollCalculation.getDescription() != null) {
            query.Set("prc_description", payrollCalculation.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
