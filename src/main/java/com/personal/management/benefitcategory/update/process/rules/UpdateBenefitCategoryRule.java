package com.personal.management.benefitcategory.update.process.rules;

import com.personal.management.benefitcategory.factories.BenefitCategoryServiceFactory;
import com.personal.management.benefitcategory.update.process.UpdateBenefitCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateBenefitCategoryRule implements IProcessRule<UpdateBenefitCategoryProcess> {

    @Override
    public void apply(UpdateBenefitCategoryProcess process) {

        var pLogger = LogFactory.builder(UpdateBenefitCategoryProcess.class, UpdateBenefitCategoryRule.class);
        var createBenefitCategory = BenefitCategoryServiceFactory.EditBenefitCategory();
        var result = createBenefitCategory.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
