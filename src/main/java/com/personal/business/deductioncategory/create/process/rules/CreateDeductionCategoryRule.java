package com.personal.business.deductioncategory.create.process.rules;

import com.personal.business.deductioncategory.create.process.CreateDeductionCategoryProcess;
import com.personal.business.deductioncategory.factories.DeductionCategoryServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateDeductionCategoryRule implements IProcessRule<CreateDeductionCategoryProcess> {

    @Override
    public void apply(CreateDeductionCategoryProcess process) {

        var pLogger = LogFactory.builder(CreateDeductionCategoryProcess.class, CreateDeductionCategoryRule.class);
        var deductionCategory = process.getInitObject();
        var createDeductionCategory = DeductionCategoryServiceFactory.CreateDeductionCategory(deductionCategory.getBusiness().getDbName());
        var result = createDeductionCategory.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
