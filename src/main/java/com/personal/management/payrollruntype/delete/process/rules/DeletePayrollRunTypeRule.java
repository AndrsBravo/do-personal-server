package com.personal.management.payrollruntype.delete.process.rules;

import com.personal.management.payrollruntype.delete.process.DeletePayrollRunTypeProcess;
import com.personal.management.payrollruntype.factories.PayrollRunTypeServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeletePayrollRunTypeRule implements IProcessRule<DeletePayrollRunTypeProcess> {

    @Override
    public void apply(DeletePayrollRunTypeProcess process) {

        var pLogger = LogFactory.builder(DeletePayrollRunTypeProcess.class, DeletePayrollRunTypeRule.class);

        var query = process.Query();
        var payrollRunType = process.getInitObject();

        query.Field("id", payrollRunType.getId());
        query.Where().Equ("id");

        var createPayrollRunType = PayrollRunTypeServiceFactory.DeletePayrollRunType();
        var result = createPayrollRunType.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
