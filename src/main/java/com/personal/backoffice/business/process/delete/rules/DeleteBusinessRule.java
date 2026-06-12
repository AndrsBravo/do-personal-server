package com.personal.backoffice.business.process.delete.rules;

import com.personal.backoffice.business.factories.BusinessServiceFactory;
import com.personal.backoffice.business.process.delete.DeleteBusinessProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteBusinessRule implements IProcessRule<DeleteBusinessProcess> {

    @Override
    public void apply(DeleteBusinessProcess process) {

        var pLogger = LogFactory.builder(DeleteBusinessProcess.class, DeleteBusinessRule.class);

        var query = process.Query();
        var business = process.getInitObject();

        query.Field("id", business.getId());
        query.Where().Equ("id");

        var createBusiness = BusinessServiceFactory.DeleteBusiness();
        var result = createBusiness.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
