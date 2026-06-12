package com.personal.management.financecategory.delete.process.rules;

import com.personal.management.financecategory.delete.process.DeleteFinanceCategoryProcess;
import com.personal.management.financecategory.factories.FinanceCategoryServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteFinanceCategoryRule implements IProcessRule<DeleteFinanceCategoryProcess> {

    @Override
    public void apply(DeleteFinanceCategoryProcess process) {

        var pLogger = LogFactory.builder(DeleteFinanceCategoryProcess.class, DeleteFinanceCategoryRule.class);

        var query = process.Query();
        var financeCategory = process.getInitObject();

        query.Field("id", financeCategory.getId());
        query.Where().Equ("id");

        var createFinanceCategory = FinanceCategoryServiceFactory.DeleteFinanceCategory();
        var result = createFinanceCategory.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
