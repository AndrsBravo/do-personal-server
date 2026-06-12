package com.personal.business.payrollbenefit.create.process.rules;

import com.personal.business.payrollbenefit.create.process.CreatePayrollBenefitProcess;
import com.personal.business.payrollbenefit.factories.PayrollBenefitServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollBenefitRule implements IProcessRule<CreatePayrollBenefitProcess> {

    @Override
    public void apply(CreatePayrollBenefitProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollBenefitProcess.class, CreatePayrollBenefitRule.class);
        var payrollBenefit = process.getInitObject();
        var createPayrollBenefit = PayrollBenefitServiceFactory.CreatePayrollBenefit(payrollBenefit.getBusiness().getDbName());
        var result = createPayrollBenefit.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
