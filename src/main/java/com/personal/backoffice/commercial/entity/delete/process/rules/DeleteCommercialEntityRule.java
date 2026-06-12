package com.personal.backoffice.commercial.entity.delete.process.rules;

import com.personal.backoffice.commercial.entity.factories.CommercialEntityServiceFactory;
import com.personal.backoffice.commercial.entity.delete.process.DeleteCommercialEntityProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteCommercialEntityRule implements IProcessRule<DeleteCommercialEntityProcess> {

    @Override
    public void apply(DeleteCommercialEntityProcess process) {

        var pLogger = LogFactory.builder(DeleteCommercialEntityProcess.class, DeleteCommercialEntityRule.class);

        var query = process.Query();
        var commercialEntity = process.getInitObject();

        query.Field("id", commercialEntity.getId());
        query.Where().Equ("id");

        var createCommercialEntity = CommercialEntityServiceFactory.DeleteCommercialEntity();
        var result = createCommercialEntity.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
