package com.personal.business.payroll.create.process.rules;

import com.personal.business.payroll.create.process.CreatePayrollProcess;
import com.personal.business.payroll.factories.PayrollServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollRule implements IProcessRule<CreatePayrollProcess> {

    @Override
    public void apply(CreatePayrollProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollProcess.class, CreatePayrollRule.class);
        var payroll = process.getInitObject();
        var createPayroll = PayrollServiceFactory.CreatePayroll(payroll.getBusiness().getDbName());
        var result = createPayroll.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
