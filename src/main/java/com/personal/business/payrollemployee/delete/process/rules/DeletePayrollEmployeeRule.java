package com.personal.business.payrollemployee.delete.process.rules;

import com.personal.business.payrollemployee.delete.process.DeletePayrollEmployeeProcess;
import com.personal.business.payrollemployee.factories.PayrollEmployeeServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeletePayrollEmployeeRule implements IProcessRule<DeletePayrollEmployeeProcess> {

    @Override
    public void apply(DeletePayrollEmployeeProcess process) {

        var pLogger = LogFactory.builder(DeletePayrollEmployeeProcess.class, DeletePayrollEmployeeRule.class);

        var query = process.Query();
        var payrollEmployee = process.getInitObject();

        query.Field("id", payrollEmployee.getId());
        query.Where().Equ("id");

        var createPayrollEmployee = PayrollEmployeeServiceFactory.DeletePayrollEmployee(payrollEmployee.getBusiness().getDbName());
        var result = createPayrollEmployee.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
