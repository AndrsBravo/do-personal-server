package com.personal.management.benefitdeductionrelation.create.process.rules;

import com.personal.management.benefitdeductionrelation.create.process.CreateBenefitDeductionRelationProcess;
import com.personal.management.benefitdeductionrelation.factories.BenefitDeductionRelationServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateBenefitDeductionRelationRule implements IProcessRule<CreateBenefitDeductionRelationProcess> {

    @Override
    public void apply(CreateBenefitDeductionRelationProcess process) {

        var pLogger = LogFactory.builder(CreateBenefitDeductionRelationProcess.class, CreateBenefitDeductionRelationRule.class);
        var createBenefitDeductionRelation = BenefitDeductionRelationServiceFactory.CreateBenefitDeductionRelation();
        var result = createBenefitDeductionRelation.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
