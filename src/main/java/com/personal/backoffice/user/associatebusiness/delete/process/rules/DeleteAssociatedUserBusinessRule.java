package com.personal.backoffice.user.associatebusiness.delete.process.rules;

import com.personal.backoffice.user.associatebusiness.delete.process.DeleteAssociatedUserBusinessProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteAssociatedUserBusinessRule implements IProcessRule<DeleteAssociatedUserBusinessProcess> {

    @Override
    public void apply(DeleteAssociatedUserBusinessProcess process) {

        var pLogger = LogFactory.builder(DeleteAssociatedUserBusinessProcess.class, DeleteAssociatedUserBusinessRule.class);

        var query = process.Query();
        var associatedUserBusiness = process.getInitObject();

        query.Field("users_id", associatedUserBusiness.getUser().getId());
        query.Where().Equ("users_id");
        query.Field("business_id", associatedUserBusiness.getBusiness().getId());
        query.Where().AndEqu("business_id");

        var associatedUserBusinessService = UserServiceFactory.DeleteAssociatedUserBusinessService();
        var result = associatedUserBusinessService.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar relación Usuario, Empresa", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar relación Usuario, Empresa", "Relación Usuario, Empresa eliminada con éxito"));

    }

}
