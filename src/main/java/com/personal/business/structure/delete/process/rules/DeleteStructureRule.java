package com.personal.business.structure.delete.process.rules;

import com.personal.business.structure.delete.process.DeleteStructureProcess;
import com.personal.business.structure.factories.StructureServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteStructureRule implements IProcessRule<DeleteStructureProcess> {

    @Override
    public void apply(DeleteStructureProcess process) {

        var pLogger = LogFactory.builder(DeleteStructureProcess.class, DeleteStructureRule.class);

        var query = process.Query();
        var structure = process.getInitObject();

        query.Field("id", structure.getId());
        query.Where().Equ("id");

        var createStructure = StructureServiceFactory.DeleteStructure(structure.getBusiness().getDbName());
        var result = createStructure.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
