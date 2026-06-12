package com.personal.business.payrollcalculation.delete.process.rules;

import com.personal.business.payrollcalculation.delete.process.DeletePayrollCalculationProcess;
import com.personal.business.payrollcalculation.factories.PayrollCalculationServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeletePayrollCalculationRule implements IProcessRule<DeletePayrollCalculationProcess> {

    @Override
    public void apply(DeletePayrollCalculationProcess process) {

        var pLogger = LogFactory.builder(DeletePayrollCalculationProcess.class, DeletePayrollCalculationRule.class);

        var query = process.Query();
        var payrollCalculation = process.getInitObject();

        query.Field("id", payrollCalculation.getId());
        query.Where().Equ("id");

        var createPayrollCalculation = PayrollCalculationServiceFactory.DeletePayrollCalculation(payrollCalculation.getBusiness().getDbName());
        var result = createPayrollCalculation.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
