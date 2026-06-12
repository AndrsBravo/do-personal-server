package com.personal.business.payrollruntype.create.process.rules;

import com.personal.business.payrollruntype.create.process.CreatePayrollRunTypeProcess;
import com.personal.business.payrollruntype.factories.PayrollRunTypeServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollRunTypeRule implements IProcessRule<CreatePayrollRunTypeProcess> {

    @Override
    public void apply(CreatePayrollRunTypeProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollRunTypeProcess.class, CreatePayrollRunTypeRule.class);
        var payrollRunType = process.getInitObject();
        var createPayrollRunType = PayrollRunTypeServiceFactory.CreatePayrollRunType(payrollRunType.getBusiness().getDbName());
        var result = createPayrollRunType.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
