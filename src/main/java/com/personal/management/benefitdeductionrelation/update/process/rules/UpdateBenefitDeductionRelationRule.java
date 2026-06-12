package com.personal.management.benefitdeductionrelation.update.process.rules;

import com.personal.management.benefitdeductionrelation.factories.BenefitDeductionRelationServiceFactory;
import com.personal.management.benefitdeductionrelation.update.process.UpdateBenefitDeductionRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateBenefitDeductionRelationRule implements IProcessRule<UpdateBenefitDeductionRelationProcess> {

    @Override
    public void apply(UpdateBenefitDeductionRelationProcess process) {

        var pLogger = LogFactory.builder(UpdateBenefitDeductionRelationProcess.class, UpdateBenefitDeductionRelationRule.class);
        var createBenefitDeductionRelation = BenefitDeductionRelationServiceFactory.EditBenefitDeductionRelation();
        var result = createBenefitDeductionRelation.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
