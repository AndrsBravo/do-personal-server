package com.personal.management.financecategory.update.process.rules;

import com.personal.management.financecategory.factories.FinanceCategoryServiceFactory;
import com.personal.management.financecategory.update.process.UpdateFinanceCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFinanceCategoryRule implements IProcessRule<UpdateFinanceCategoryProcess> {

    @Override
    public void apply(UpdateFinanceCategoryProcess process) {

        var pLogger = LogFactory.builder(UpdateFinanceCategoryProcess.class, UpdateFinanceCategoryRule.class);
        var createFinanceCategory = FinanceCategoryServiceFactory.EditFinanceCategory();
        var result = createFinanceCategory.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
