package com.personal.business.payrollrunresult.delete.process.rules;

import com.personal.business.payrollrunresult.delete.process.DeletePayrollRunResultProcess;
import com.personal.business.payrollrunresult.factories.PayrollRunResultServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeletePayrollRunResultRule implements IProcessRule<DeletePayrollRunResultProcess> {

    @Override
    public void apply(DeletePayrollRunResultProcess process) {

        var pLogger = LogFactory.builder(DeletePayrollRunResultProcess.class, DeletePayrollRunResultRule.class);

        var query = process.Query();
        var payrollRunResult = process.getInitObject();

        query.Field("id", payrollRunResult.getId());
        query.Where().Equ("id");

        var createPayrollRunResult = PayrollRunResultServiceFactory.DeletePayrollRunResult(payrollRunResult.getBusiness().getDbName());
        var result = createPayrollRunResult.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
