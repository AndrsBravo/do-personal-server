package com.personal.business.employeebenefit.delete.process.rules;

import com.personal.business.employeebenefit.delete.process.DeleteEmployeeBenefitProcess;
import com.personal.business.employeebenefit.factories.EmployeeBenefitServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteEmployeeBenefitRule implements IProcessRule<DeleteEmployeeBenefitProcess> {

    @Override
    public void apply(DeleteEmployeeBenefitProcess process) {

        var pLogger = LogFactory.builder(DeleteEmployeeBenefitProcess.class, DeleteEmployeeBenefitRule.class);

        var query = process.Query();
        var employeeBenefit = process.getInitObject();

        query.Field("id", employeeBenefit.getId());
        query.Where().Equ("id");

        var createEmployeeBenefit = EmployeeBenefitServiceFactory.DeleteEmployeeBenefit(employeeBenefit.getBusiness().getDbName());
        var result = createEmployeeBenefit.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
