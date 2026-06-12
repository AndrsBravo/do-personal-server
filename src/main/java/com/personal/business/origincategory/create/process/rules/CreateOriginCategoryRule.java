package com.personal.business.origincategory.create.process.rules;

import com.personal.business.origincategory.create.process.CreateOriginCategoryProcess;
import com.personal.business.origincategory.factories.OriginCategoryServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateOriginCategoryRule implements IProcessRule<CreateOriginCategoryProcess> {

    @Override
    public void apply(CreateOriginCategoryProcess process) {

        var pLogger = LogFactory.builder(CreateOriginCategoryProcess.class, CreateOriginCategoryRule.class);

        var originCategory = process.getInitObject();

        var createOriginCategory = OriginCategoryServiceFactory.CreateOriginCategory(originCategory.getBusiness().getDbName());
        var result = createOriginCategory.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
