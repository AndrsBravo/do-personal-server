package com.personal.business.deductionrate.delete.process.rules;

import com.personal.business.deductionrate.delete.process.DeleteDeductionRateProcess;
import com.personal.business.deductionrate.factories.DeductionRateServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteDeductionRateRule implements IProcessRule<DeleteDeductionRateProcess> {

    @Override
    public void apply(DeleteDeductionRateProcess process) {

        var pLogger = LogFactory.builder(DeleteDeductionRateProcess.class, DeleteDeductionRateRule.class);

        var query = process.Query();
        var deductionRate = process.getInitObject();

        query.Field("id", deductionRate.getId());
        query.Where().Equ("id");

        var createDeductionRate = DeductionRateServiceFactory.DeleteDeductionRate(deductionRate.getBusiness().getDbName());
        var result = createDeductionRate.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
