package com.personal.management.payrolldeduction.delete.process.rules;

import com.personal.management.payrolldeduction.delete.process.DeletePayrollDeductionProcess;
import com.personal.management.payrolldeduction.factories.PayrollDeductionServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeletePayrollDeductionRule implements IProcessRule<DeletePayrollDeductionProcess> {

    @Override
    public void apply(DeletePayrollDeductionProcess process) {

        var pLogger = LogFactory.builder(DeletePayrollDeductionProcess.class, DeletePayrollDeductionRule.class);

        var query = process.Query();
        var payrollDeduction = process.getInitObject();

        query.Field("id", payrollDeduction.getId());
        query.Where().Equ("id");

        var createPayrollDeduction = PayrollDeductionServiceFactory.DeletePayrollDeduction();
        var result = createPayrollDeduction.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
