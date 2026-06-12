package com.personal.business.benefitdeductionrelation.update.process.rules;

import com.personal.business.benefitdeductionrelation.factories.BenefitDeductionRelationServiceFactory;
import com.personal.business.benefitdeductionrelation.update.process.UpdateBenefitDeductionRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateBenefitDeductionRelationRule implements IProcessRule<UpdateBenefitDeductionRelationProcess> {

    @Override
    public void apply(UpdateBenefitDeductionRelationProcess process) {

        var pLogger = LogFactory.builder(UpdateBenefitDeductionRelationProcess.class, UpdateBenefitDeductionRelationRule.class);
        var benefitDeductionRelation = process.getInitObject();
        var createBenefitDeductionRelation = BenefitDeductionRelationServiceFactory.EditBenefitDeductionRelation(benefitDeductionRelation.getBusiness().getDbName());
        var result = createBenefitDeductionRelation.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
