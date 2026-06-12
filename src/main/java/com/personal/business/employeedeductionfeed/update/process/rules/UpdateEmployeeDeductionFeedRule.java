package com.personal.business.employeedeductionfeed.update.process.rules;

import com.personal.business.employeedeductionfeed.factories.EmployeeDeductionFeedServiceFactory;
import com.personal.business.employeedeductionfeed.update.process.UpdateEmployeeDeductionFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateEmployeeDeductionFeedRule implements IProcessRule<UpdateEmployeeDeductionFeedProcess> {

    @Override
    public void apply(UpdateEmployeeDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeDeductionFeedProcess.class, UpdateEmployeeDeductionFeedRule.class);
        var employeeDeductionFeed = process.getInitObject();
        var createEmployeeDeductionFeed = EmployeeDeductionFeedServiceFactory.EditEmployeeDeductionFeed(employeeDeductionFeed.getBusiness().getDbName());
        var result = createEmployeeDeductionFeed.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
