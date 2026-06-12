package com.personal.business.employeededuction.delete.process.rules;

import com.personal.business.employeededuction.delete.process.DeleteEmployeeDeductionProcess;
import com.personal.business.employeededuction.factories.EmployeeDeductionServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteEmployeeDeductionRule implements IProcessRule<DeleteEmployeeDeductionProcess> {

    @Override
    public void apply(DeleteEmployeeDeductionProcess process) {

        var pLogger = LogFactory.builder(DeleteEmployeeDeductionProcess.class, DeleteEmployeeDeductionRule.class);

        var query = process.Query();
        var employeeDeduction = process.getInitObject();

        query.Field("id", employeeDeduction.getId());
        query.Where().Equ("id");

        var createEmployeeDeduction = EmployeeDeductionServiceFactory.DeleteEmployeeDeduction(employeeDeduction.getBusiness().getDbName());
        var result = createEmployeeDeduction.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
