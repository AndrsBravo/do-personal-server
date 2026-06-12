package com.personal.business.employeebenefit.update.process.rules;

import com.personal.business.employeebenefit.factories.EmployeeBenefitServiceFactory;
import com.personal.business.employeebenefit.update.process.UpdateEmployeeBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateEmployeeBenefitRule implements IProcessRule<UpdateEmployeeBenefitProcess> {

    @Override
    public void apply(UpdateEmployeeBenefitProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeBenefitProcess.class, UpdateEmployeeBenefitRule.class);
        var employeeBenefit = process.getInitObject();
        var createEmployeeBenefit = EmployeeBenefitServiceFactory.EditEmployeeBenefit(employeeBenefit.getBusiness().getDbName());
        var result = createEmployeeBenefit.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
