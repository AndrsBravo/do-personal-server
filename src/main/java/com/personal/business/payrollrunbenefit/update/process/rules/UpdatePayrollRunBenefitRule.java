package com.personal.business.payrollrunbenefit.update.process.rules;

import com.personal.business.payrollrunbenefit.factories.PayrollRunBenefitServiceFactory;
import com.personal.business.payrollrunbenefit.update.process.UpdatePayrollRunBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollRunBenefitRule implements IProcessRule<UpdatePayrollRunBenefitProcess> {

    @Override
    public void apply(UpdatePayrollRunBenefitProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollRunBenefitProcess.class, UpdatePayrollRunBenefitRule.class);
        var payrollRunBenefit = process.getInitObject();
        var createPayrollRunBenefit = PayrollRunBenefitServiceFactory.EditPayrollRunBenefit(payrollRunBenefit.getBusiness().getDbName());
        var result = createPayrollRunBenefit.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
