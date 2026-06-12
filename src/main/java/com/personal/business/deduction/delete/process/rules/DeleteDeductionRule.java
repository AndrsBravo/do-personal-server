package com.personal.business.deduction.delete.process.rules;

import com.personal.business.deduction.delete.process.DeleteDeductionProcess;
import com.personal.business.deduction.factories.DeductionServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteDeductionRule implements IProcessRule<DeleteDeductionProcess> {

    @Override
    public void apply(DeleteDeductionProcess process) {

        var pLogger = LogFactory.builder(DeleteDeductionProcess.class, DeleteDeductionRule.class);

        var query = process.Query();
        var deduction = process.getInitObject();

        query.Field("id", deduction.getId());
        query.Where().Equ("id");

        var createDeduction = DeductionServiceFactory.DeleteDeduction(deduction.getBusiness().getDbName());
        var result = createDeduction.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
