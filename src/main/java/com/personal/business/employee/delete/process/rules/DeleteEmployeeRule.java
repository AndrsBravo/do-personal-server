package com.personal.business.employee.delete.process.rules;

import com.personal.business.employee.delete.process.DeleteEmployeeProcess;
import com.personal.business.employee.factories.EmployeeServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteEmployeeRule implements IProcessRule<DeleteEmployeeProcess> {

    @Override
    public void apply(DeleteEmployeeProcess process) {

        var pLogger = LogFactory.builder(DeleteEmployeeProcess.class, DeleteEmployeeRule.class);

        var query = process.Query();
        var employee = process.getInitObject();

        query.Field("id", employee.getId());
        query.Where().Equ("id");

        var createEmployee = EmployeeServiceFactory.DeleteEmployee(employee.getBusiness().getDbName());
        var result = createEmployee.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
