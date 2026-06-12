package com.personal.business.origincategory.update.process.rules;

import com.personal.business.origincategory.factories.OriginCategoryServiceFactory;
import com.personal.business.origincategory.update.process.UpdateOriginCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateOriginCategoryRule implements IProcessRule<UpdateOriginCategoryProcess> {

    @Override
    public void apply(UpdateOriginCategoryProcess process) {

        var pLogger = LogFactory.builder(UpdateOriginCategoryProcess.class, UpdateOriginCategoryRule.class);
        var originCategory = process.getInitObject();
        var createOriginCategory = OriginCategoryServiceFactory.EditOriginCategory(originCategory.getBusiness().getDbName());
        var result = createOriginCategory.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
