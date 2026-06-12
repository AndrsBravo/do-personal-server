package com.personal.business.deductioncategory.update.process.rules;

import com.personal.business.deductioncategory.factories.DeductionCategoryServiceFactory;
import com.personal.business.deductioncategory.update.process.UpdateDeductionCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateDeductionCategoryRule implements IProcessRule<UpdateDeductionCategoryProcess> {

    @Override
    public void apply(UpdateDeductionCategoryProcess process) {

        var pLogger = LogFactory.builder(UpdateDeductionCategoryProcess.class, UpdateDeductionCategoryRule.class);
        var deductionCategory = process.getInitObject();
        var createDeductionCategory = DeductionCategoryServiceFactory.EditDeductionCategory(deductionCategory.getBusiness().getDbName());
        var result = createDeductionCategory.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
