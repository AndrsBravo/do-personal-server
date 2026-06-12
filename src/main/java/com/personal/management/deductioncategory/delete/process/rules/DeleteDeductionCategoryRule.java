package com.personal.management.deductioncategory.delete.process.rules;

import com.personal.management.deductioncategory.delete.process.DeleteDeductionCategoryProcess;
import com.personal.management.deductioncategory.factories.DeductionCategoryServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteDeductionCategoryRule implements IProcessRule<DeleteDeductionCategoryProcess> {

    @Override
    public void apply(DeleteDeductionCategoryProcess process) {

        var pLogger = LogFactory.builder(DeleteDeductionCategoryProcess.class, DeleteDeductionCategoryRule.class);

        var query = process.Query();
        var deductionCategory = process.getInitObject();

        query.Field("id", deductionCategory.getId());
        query.Where().Equ("id");

        var createDeductionCategory = DeductionCategoryServiceFactory.DeleteDeductionCategory();
        var result = createDeductionCategory.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
