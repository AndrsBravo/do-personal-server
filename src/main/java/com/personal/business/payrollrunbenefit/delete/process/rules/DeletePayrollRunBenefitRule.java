package com.personal.business.payrollrunbenefit.delete.process.rules;

import com.personal.business.payrollrunbenefit.delete.process.DeletePayrollRunBenefitProcess;
import com.personal.business.payrollrunbenefit.factories.PayrollRunBenefitServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeletePayrollRunBenefitRule implements IProcessRule<DeletePayrollRunBenefitProcess> {

    @Override
    public void apply(DeletePayrollRunBenefitProcess process) {

        var pLogger = LogFactory.builder(DeletePayrollRunBenefitProcess.class, DeletePayrollRunBenefitRule.class);

        var query = process.Query();
        var payrollRunBenefit = process.getInitObject();

        query.Field("id", payrollRunBenefit.getId());
        query.Where().Equ("id");

        var createPayrollRunBenefit = PayrollRunBenefitServiceFactory.DeletePayrollRunBenefit(payrollRunBenefit.getBusiness().getDbName());
        var result = createPayrollRunBenefit.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
