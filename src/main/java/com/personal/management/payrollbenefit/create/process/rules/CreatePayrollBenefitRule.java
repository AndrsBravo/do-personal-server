package com.personal.management.payrollbenefit.create.process.rules;

import com.personal.management.payrollbenefit.create.process.CreatePayrollBenefitProcess;
import com.personal.management.payrollbenefit.factories.PayrollBenefitServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollBenefitRule implements IProcessRule<CreatePayrollBenefitProcess> {

    @Override
    public void apply(CreatePayrollBenefitProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollBenefitProcess.class, CreatePayrollBenefitRule.class);
        var createPayrollBenefit = PayrollBenefitServiceFactory.CreatePayrollBenefit();
        var result = createPayrollBenefit.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
