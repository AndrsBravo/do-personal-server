package com.personal.business.employeebenefitfeed.update.process.rules;

import com.personal.business.employeebenefitfeed.factories.EmployeeBenefitFeedServiceFactory;
import com.personal.business.employeebenefitfeed.update.process.UpdateEmployeeBenefitFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateEmployeeBenefitFeedRule implements IProcessRule<UpdateEmployeeBenefitFeedProcess> {

    @Override
    public void apply(UpdateEmployeeBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeBenefitFeedProcess.class, UpdateEmployeeBenefitFeedRule.class);
        var employeeBenefitFeed = process.getInitObject();
        var createEmployeeBenefitFeed = EmployeeBenefitFeedServiceFactory.EditEmployeeBenefitFeed(employeeBenefitFeed.getBusiness().getDbName());
        var result = createEmployeeBenefitFeed.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
