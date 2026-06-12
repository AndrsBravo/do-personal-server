package com.personal.business.payrolldeduction.create.process.rules;

import com.personal.business.payrolldeduction.create.process.CreatePayrollDeductionProcess;
import com.personal.business.payrolldeduction.factories.PayrollDeductionServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollDeductionRule implements IProcessRule<CreatePayrollDeductionProcess> {

    @Override
    public void apply(CreatePayrollDeductionProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollDeductionProcess.class, CreatePayrollDeductionRule.class);
        var payrollDeduction = process.getInitObject();
        var createPayrollDeduction = PayrollDeductionServiceFactory.CreatePayrollDeduction(payrollDeduction.getBusiness().getDbName());
        var result = createPayrollDeduction.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
