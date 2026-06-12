package com.personal.business.employeebenefitfeed.create.process.rules;

import com.personal.business.employeebenefitfeed.create.process.CreateEmployeeBenefitFeedProcess;
import com.personal.business.employeebenefitfeed.factories.EmployeeBenefitFeedServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateEmployeeBenefitFeedRule implements IProcessRule<CreateEmployeeBenefitFeedProcess> {

    @Override
    public void apply(CreateEmployeeBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeBenefitFeedProcess.class, CreateEmployeeBenefitFeedRule.class);
        var employeeBenefitFeed = process.getInitObject();
        var createEmployeeBenefitFeed = EmployeeBenefitFeedServiceFactory.CreateEmployeeBenefitFeed(employeeBenefitFeed.getBusiness().getDbName());
        var result = createEmployeeBenefitFeed.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
