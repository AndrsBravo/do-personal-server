package com.personal.management.benefitrate.delete.process.rules;

import com.personal.management.benefitrate.delete.process.DeleteBenefitRateProcess;
import com.personal.management.benefitrate.factories.BenefitRateServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteBenefitRateRule implements IProcessRule<DeleteBenefitRateProcess> {

    @Override
    public void apply(DeleteBenefitRateProcess process) {

        var pLogger = LogFactory.builder(DeleteBenefitRateProcess.class, DeleteBenefitRateRule.class);

        var query = process.Query();
        var benefitRate = process.getInitObject();

        query.Field("id", benefitRate.getId());
        query.Where().Equ("id");

        var createBenefitRate = BenefitRateServiceFactory.DeleteBenefitRate();
        var result = createBenefitRate.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
