package com.personal.business.employeedeductionfeed.delete.process.rules;

import com.personal.business.employeedeductionfeed.delete.process.DeleteEmployeeDeductionFeedProcess;
import com.personal.business.employeedeductionfeed.factories.EmployeeDeductionFeedServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteEmployeeDeductionFeedRule implements IProcessRule<DeleteEmployeeDeductionFeedProcess> {

    @Override
    public void apply(DeleteEmployeeDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(DeleteEmployeeDeductionFeedProcess.class, DeleteEmployeeDeductionFeedRule.class);

        var query = process.Query();
        var employeeDeductionFeed = process.getInitObject();

        query.Field("id", employeeDeductionFeed.getId());
        query.Where().Equ("id");

        var createEmployeeDeductionFeed = EmployeeDeductionFeedServiceFactory.DeleteEmployeeDeductionFeed(employeeDeductionFeed.getBusiness().getDbName());
        var result = createEmployeeDeductionFeed.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
