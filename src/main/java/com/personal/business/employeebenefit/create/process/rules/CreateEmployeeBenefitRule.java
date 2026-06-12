package com.personal.business.employeebenefit.create.process.rules;

import com.personal.business.employeebenefit.create.process.CreateEmployeeBenefitProcess;
import com.personal.business.employeebenefit.factories.EmployeeBenefitServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateEmployeeBenefitRule implements IProcessRule<CreateEmployeeBenefitProcess> {

    @Override
    public void apply(CreateEmployeeBenefitProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeBenefitProcess.class, CreateEmployeeBenefitRule.class);
        var employeeBenefit = process.getInitObject();
        var createEmployeeBenefit = EmployeeBenefitServiceFactory.CreateEmployeeBenefit(employeeBenefit.getBusiness().getDbName());
        var result = createEmployeeBenefit.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
