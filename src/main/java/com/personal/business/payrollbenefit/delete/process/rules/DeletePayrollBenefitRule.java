package com.personal.business.payrollbenefit.delete.process.rules;

import com.personal.business.payrollbenefit.delete.process.DeletePayrollBenefitProcess;
import com.personal.business.payrollbenefit.factories.PayrollBenefitServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeletePayrollBenefitRule implements IProcessRule<DeletePayrollBenefitProcess> {

    @Override
    public void apply(DeletePayrollBenefitProcess process) {

        var pLogger = LogFactory.builder(DeletePayrollBenefitProcess.class, DeletePayrollBenefitRule.class);

        var query = process.Query();
        var payrollBenefit = process.getInitObject();

        query.Field("id", payrollBenefit.getId());
        query.Where().Equ("id");

        var createPayrollBenefit = PayrollBenefitServiceFactory.DeletePayrollBenefit(payrollBenefit.getBusiness().getDbName());
        var result = createPayrollBenefit.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
