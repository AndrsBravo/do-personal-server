package com.personal.business.employeescale.delete.process.rules;

import com.personal.business.employeescale.delete.process.DeleteEmployeeScaleProcess;
import com.personal.business.employeescale.factories.EmployeeScaleServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteEmployeeScaleRule implements IProcessRule<DeleteEmployeeScaleProcess> {

    @Override
    public void apply(DeleteEmployeeScaleProcess process) {

        var pLogger = LogFactory.builder(DeleteEmployeeScaleProcess.class, DeleteEmployeeScaleRule.class);

        var query = process.Query();
        var employeeScale = process.getInitObject();

        query.Field("id", employeeScale.getId());
        query.Where().Equ("id");

        var createEmployeeScale = EmployeeScaleServiceFactory.DeleteEmployeeScale(employeeScale.getBusiness().getDbName());
        var result = createEmployeeScale.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
