package com.personal.management.benefit.delete.process.rules;

import com.personal.management.benefit.delete.process.DeleteBenefitProcess;
import com.personal.management.benefit.factories.BenefitServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteBenefitRule implements IProcessRule<DeleteBenefitProcess> {

    @Override
    public void apply(DeleteBenefitProcess process) {

        var pLogger = LogFactory.builder(DeleteBenefitProcess.class, DeleteBenefitRule.class);

        var query = process.Query();
        var benefit = process.getInitObject();

        query.Field("id", benefit.getId());
        query.Where().Equ("id");

        var createBenefit = BenefitServiceFactory.DeleteBenefit();
        var result = createBenefit.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
