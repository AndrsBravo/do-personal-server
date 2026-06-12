package com.personal.business.employeedeductionfeed.create.process.rules;

import com.personal.business.employeedeductionfeed.create.process.CreateEmployeeDeductionFeedProcess;
import com.personal.business.employeedeductionfeed.factories.EmployeeDeductionFeedServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateEmployeeDeductionFeedRule implements IProcessRule<CreateEmployeeDeductionFeedProcess> {

    @Override
    public void apply(CreateEmployeeDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeDeductionFeedProcess.class, CreateEmployeeDeductionFeedRule.class);
        var employeeDeductionFeed = process.getInitObject();
        var createEmployeeDeductionFeed = EmployeeDeductionFeedServiceFactory.CreateEmployeeDeductionFeed(employeeDeductionFeed.getBusiness().getDbName());
        var result = createEmployeeDeductionFeed.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
