package com.personal.management.payrollbenefit.update.process.rules;

import com.personal.management.payrollbenefit.factories.PayrollBenefitServiceFactory;
import com.personal.management.payrollbenefit.update.process.UpdatePayrollBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollBenefitRule implements IProcessRule<UpdatePayrollBenefitProcess> {

    @Override
    public void apply(UpdatePayrollBenefitProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollBenefitProcess.class, UpdatePayrollBenefitRule.class);
        var createPayrollBenefit = PayrollBenefitServiceFactory.EditPayrollBenefit();
        var result = createPayrollBenefit.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
