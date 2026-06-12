package com.personal.management.benefitcategory.create.process.rules;

import com.personal.management.benefitcategory.create.process.CreateBenefitCategoryProcess;
import com.personal.management.benefitcategory.factories.BenefitCategoryServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateBenefitCategoryRule implements IProcessRule<CreateBenefitCategoryProcess> {

    @Override
    public void apply(CreateBenefitCategoryProcess process) {

        var pLogger = LogFactory.builder(CreateBenefitCategoryProcess.class, CreateBenefitCategoryRule.class);
        var createBenefitCategory = BenefitCategoryServiceFactory.CreateBenefitCategory();
        var result = createBenefitCategory.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
