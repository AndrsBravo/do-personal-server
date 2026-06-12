package com.personal.business.payrollbenefit.update.process.rules;

import com.personal.business.payrollbenefit.factories.PayrollBenefitServiceFactory;
import com.personal.business.payrollbenefit.update.process.UpdatePayrollBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollBenefitRule implements IProcessRule<UpdatePayrollBenefitProcess> {

    @Override
    public void apply(UpdatePayrollBenefitProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollBenefitProcess.class, UpdatePayrollBenefitRule.class);
        var payrollBenefit = process.getInitObject();
        var createPayrollBenefit = PayrollBenefitServiceFactory.EditPayrollBenefit(payrollBenefit.getBusiness().getDbName());
        var result = createPayrollBenefit.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
