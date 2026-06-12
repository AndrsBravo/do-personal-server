package com.personal.management.financecategory.create.process.rules;

import com.personal.management.financecategory.create.process.CreateFinanceCategoryProcess;
import com.personal.management.financecategory.factories.FinanceCategoryServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateFinanceCategoryRule implements IProcessRule<CreateFinanceCategoryProcess> {

    @Override
    public void apply(CreateFinanceCategoryProcess process) {

        var pLogger = LogFactory.builder(CreateFinanceCategoryProcess.class, CreateFinanceCategoryRule.class);
        var createFinanceCategory = FinanceCategoryServiceFactory.CreateFinanceCategory();
        var result = createFinanceCategory.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
