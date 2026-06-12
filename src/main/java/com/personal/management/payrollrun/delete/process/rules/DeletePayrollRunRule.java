package com.personal.management.payrollrun.delete.process.rules;

import com.personal.management.payrollrun.delete.process.DeletePayrollRunProcess;
import com.personal.management.payrollrun.factories.PayrollRunServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeletePayrollRunRule implements IProcessRule<DeletePayrollRunProcess> {

    @Override
    public void apply(DeletePayrollRunProcess process) {

        var pLogger = LogFactory.builder(DeletePayrollRunProcess.class, DeletePayrollRunRule.class);

        var query = process.Query();
        var payrollRun = process.getInitObject();

        query.Field("id", payrollRun.getId());
        query.Where().Equ("id");

        var createPayrollRun = PayrollRunServiceFactory.DeletePayrollRun();
        var result = createPayrollRun.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
