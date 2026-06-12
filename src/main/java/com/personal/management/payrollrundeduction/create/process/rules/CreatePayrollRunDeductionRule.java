package com.personal.management.payrollrundeduction.create.process.rules;

import com.personal.management.payrollrundeduction.create.process.CreatePayrollRunDeductionProcess;
import com.personal.management.payrollrundeduction.factories.PayrollRunDeductionServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollRunDeductionRule implements IProcessRule<CreatePayrollRunDeductionProcess> {

    @Override
    public void apply(CreatePayrollRunDeductionProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollRunDeductionProcess.class, CreatePayrollRunDeductionRule.class);
        var createPayrollRunDeduction = PayrollRunDeductionServiceFactory.CreatePayrollRunDeduction();
        var result = createPayrollRunDeduction.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
