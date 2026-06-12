package com.personal.management.payrollrunbenefit.create.process.rules;

import com.personal.management.payrollrunbenefit.create.process.CreatePayrollRunBenefitProcess;
import com.personal.management.payrollrunbenefit.factories.PayrollRunBenefitServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollRunBenefitRule implements IProcessRule<CreatePayrollRunBenefitProcess> {

    @Override
    public void apply(CreatePayrollRunBenefitProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollRunBenefitProcess.class, CreatePayrollRunBenefitRule.class);
        var createPayrollRunBenefit = PayrollRunBenefitServiceFactory.CreatePayrollRunBenefit();
        var result = createPayrollRunBenefit.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
