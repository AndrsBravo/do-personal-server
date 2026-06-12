package com.personal.business.payroll.delete.process.rules;

import com.personal.business.payroll.delete.process.DeletePayrollProcess;
import com.personal.business.payroll.factories.PayrollServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeletePayrollRule implements IProcessRule<DeletePayrollProcess> {

    @Override
    public void apply(DeletePayrollProcess process) {

        var pLogger = LogFactory.builder(DeletePayrollProcess.class, DeletePayrollRule.class);

        var query = process.Query();
        var payroll = process.getInitObject();

        query.Field("id", payroll.getId());
        query.Where().Equ("id");

        var createPayroll = PayrollServiceFactory.DeletePayroll(payroll.getBusiness().getDbName());
        var result = createPayroll.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
