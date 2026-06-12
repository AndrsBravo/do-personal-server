package com.personal.business.payrollcalculationresult.delete.process.rules;

import com.personal.business.payrollcalculationresult.delete.process.DeletePayrollCalculationResultProcess;
import com.personal.business.payrollcalculationresult.factories.PayrollCalculationResultServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeletePayrollCalculationResultRule implements IProcessRule<DeletePayrollCalculationResultProcess> {

    @Override
    public void apply(DeletePayrollCalculationResultProcess process) {

        var pLogger = LogFactory.builder(DeletePayrollCalculationResultProcess.class, DeletePayrollCalculationResultRule.class);

        var query = process.Query();
        var payrollCalculationResult = process.getInitObject();

        query.Field("id", payrollCalculationResult.getId());
        query.Where().Equ("id");

        var createPayrollCalculationResult = PayrollCalculationResultServiceFactory.DeletePayrollCalculationResult(payrollCalculationResult.getBusiness().getDbName());
        var result = createPayrollCalculationResult.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
