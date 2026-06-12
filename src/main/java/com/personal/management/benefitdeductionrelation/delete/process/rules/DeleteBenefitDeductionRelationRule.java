package com.personal.management.benefitdeductionrelation.delete.process.rules;

import com.personal.management.benefitdeductionrelation.delete.process.DeleteBenefitDeductionRelationProcess;
import com.personal.management.benefitdeductionrelation.factories.BenefitDeductionRelationServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteBenefitDeductionRelationRule implements IProcessRule<DeleteBenefitDeductionRelationProcess> {

    @Override
    public void apply(DeleteBenefitDeductionRelationProcess process) {

        var pLogger = LogFactory.builder(DeleteBenefitDeductionRelationProcess.class, DeleteBenefitDeductionRelationRule.class);

        var query = process.Query();
        var benefitDeductionRelation = process.getInitObject();

        query.Field("id", benefitDeductionRelation.getId());
        query.Where().Equ("id");

        var createBenefitDeductionRelation = BenefitDeductionRelationServiceFactory.DeleteBenefitDeductionRelation();
        var result = createBenefitDeductionRelation.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
