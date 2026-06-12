package com.personal.business.benefitcategory.create.process.rules;

import com.personal.business.benefitcategory.create.process.CreateBenefitCategoryProcess;
import com.personal.business.benefitcategory.factories.BenefitCategoryServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateBenefitCategoryRule implements IProcessRule<CreateBenefitCategoryProcess> {

    @Override
    public void apply(CreateBenefitCategoryProcess process) {

        var pLogger = LogFactory.builder(CreateBenefitCategoryProcess.class, CreateBenefitCategoryRule.class);
        var benefitCategory = process.getInitObject();
        var createBenefitCategory = BenefitCategoryServiceFactory.CreateBenefitCategory(benefitCategory.getBusiness().getDbName());
        var result = createBenefitCategory.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
