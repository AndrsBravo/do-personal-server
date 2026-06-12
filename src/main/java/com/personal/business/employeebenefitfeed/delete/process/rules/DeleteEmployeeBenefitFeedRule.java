package com.personal.business.employeebenefitfeed.delete.process.rules;

import com.personal.business.employeebenefitfeed.delete.process.DeleteEmployeeBenefitFeedProcess;
import com.personal.business.employeebenefitfeed.factories.EmployeeBenefitFeedServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteEmployeeBenefitFeedRule implements IProcessRule<DeleteEmployeeBenefitFeedProcess> {

    @Override
    public void apply(DeleteEmployeeBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(DeleteEmployeeBenefitFeedProcess.class, DeleteEmployeeBenefitFeedRule.class);

        var query = process.Query();
        var employeeBenefitFeed = process.getInitObject();

        query.Field("id", employeeBenefitFeed.getId());
        query.Where().Equ("id");

        var createEmployeeBenefitFeed = EmployeeBenefitFeedServiceFactory.DeleteEmployeeBenefitFeed(employeeBenefitFeed.getBusiness().getDbName());
        var result = createEmployeeBenefitFeed.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
