package com.personal.management.origincategory.delete.process.rules;

import com.personal.management.origincategory.delete.process.DeleteOriginCategoryProcess;
import com.personal.management.origincategory.factories.OriginCategoryServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteOriginCategoryRule implements IProcessRule<DeleteOriginCategoryProcess> {

    @Override
    public void apply(DeleteOriginCategoryProcess process) {

        var pLogger = LogFactory.builder(DeleteOriginCategoryProcess.class, DeleteOriginCategoryRule.class);

        var query = process.Query();
        var originCategory = process.getInitObject();

        query.Field("id", originCategory.getId());
        query.Where().Equ("id");

        var createOriginCategory = OriginCategoryServiceFactory.DeleteOriginCategory();
        var result = createOriginCategory.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
