package com.personal.management.payrollrundeduction.delete.process.rules;

import com.personal.management.payrollrundeduction.delete.process.DeletePayrollRunDeductionProcess;
import com.personal.management.payrollrundeduction.factories.PayrollRunDeductionServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeletePayrollRunDeductionRule implements IProcessRule<DeletePayrollRunDeductionProcess> {

    @Override
    public void apply(DeletePayrollRunDeductionProcess process) {

        var pLogger = LogFactory.builder(DeletePayrollRunDeductionProcess.class, DeletePayrollRunDeductionRule.class);

        var query = process.Query();
        var payrollRunDeduction = process.getInitObject();

        query.Field("id", payrollRunDeduction.getId());
        query.Where().Equ("id");

        var createPayrollRunDeduction = PayrollRunDeductionServiceFactory.DeletePayrollRunDeduction();
        var result = createPayrollRunDeduction.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
