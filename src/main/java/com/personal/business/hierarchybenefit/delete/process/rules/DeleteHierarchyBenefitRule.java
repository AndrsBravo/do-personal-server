package com.personal.business.hierarchybenefit.delete.process.rules;

import com.personal.business.hierarchybenefit.delete.process.DeleteHierarchyBenefitProcess;
import com.personal.business.hierarchybenefit.factories.HierarchyBenefitServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteHierarchyBenefitRule implements IProcessRule<DeleteHierarchyBenefitProcess> {

    @Override
    public void apply(DeleteHierarchyBenefitProcess process) {

        var pLogger = LogFactory.builder(DeleteHierarchyBenefitProcess.class, DeleteHierarchyBenefitRule.class);

        var query = process.Query();
        var hierarchyBenefit = process.getInitObject();

        query.Field("id", hierarchyBenefit.getId());
        query.Where().Equ("id");

        var createHierarchyBenefit = HierarchyBenefitServiceFactory.DeleteHierarchyBenefit(hierarchyBenefit.getBusiness().getDbName());
        var result = createHierarchyBenefit.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
