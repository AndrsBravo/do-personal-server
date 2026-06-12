package com.personal.business.benefitcategory.update.process.rules;

import com.personal.business.benefitcategory.factories.BenefitCategoryServiceFactory;
import com.personal.business.benefitcategory.update.process.UpdateBenefitCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateBenefitCategoryRule implements IProcessRule<UpdateBenefitCategoryProcess> {

    @Override
    public void apply(UpdateBenefitCategoryProcess process) {

        var pLogger = LogFactory.builder(UpdateBenefitCategoryProcess.class, UpdateBenefitCategoryRule.class);
        var benefitCategory = process.getInitObject();
        var createBenefitCategory = BenefitCategoryServiceFactory.EditBenefitCategory(benefitCategory.getBusiness().getDbName());
        var result = createBenefitCategory.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
