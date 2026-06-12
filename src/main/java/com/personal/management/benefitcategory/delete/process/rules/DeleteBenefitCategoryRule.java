package com.personal.management.benefitcategory.delete.process.rules;

import com.personal.management.benefitcategory.delete.process.DeleteBenefitCategoryProcess;
import com.personal.management.benefitcategory.factories.BenefitCategoryServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteBenefitCategoryRule implements IProcessRule<DeleteBenefitCategoryProcess> {

    @Override
    public void apply(DeleteBenefitCategoryProcess process) {

        var pLogger = LogFactory.builder(DeleteBenefitCategoryProcess.class, DeleteBenefitCategoryRule.class);

        var query = process.Query();
        var benefitCategory = process.getInitObject();

        query.Field("id", benefitCategory.getId());
        query.Where().Equ("id");

        var createBenefitCategory = BenefitCategoryServiceFactory.DeleteBenefitCategory();
        var result = createBenefitCategory.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
