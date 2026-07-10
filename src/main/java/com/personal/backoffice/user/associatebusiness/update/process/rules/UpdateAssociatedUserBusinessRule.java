package com.personal.backoffice.user.associatebusiness.update.process.rules;

import com.personal.backoffice.user.associatebusiness.update.process.UpdateAssociatedUserBusinessProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateAssociatedUserBusinessRule implements IProcessRule<UpdateAssociatedUserBusinessProcess> {

    @Override
    public void apply(UpdateAssociatedUserBusinessProcess process) {

        var pLogger = LogFactory.builder(UpdateAssociatedUserBusinessProcess.class, UpdateAssociatedUserBusinessRule.class);

        var query = process.Query();
        var associatedUserBusiness = process.getInitObject();

        query.Field("users_id", associatedUserBusiness.getUser().getId());
        query.Where().Equ("users_id");
        query.Field("business_id", associatedUserBusiness.getBusiness().getId());
        query.Where().AndEqu("business_id");

        if (associatedUserBusiness.getUserRole().getId() != null) {
            query.Set("user_role_id", associatedUserBusiness.getUserRole().getId());
        }
        if (associatedUserBusiness.getUserRelation() != null) {
            query.Set("user_relation_id", associatedUserBusiness.getUserRelation().getId());
        }

        var update = UserServiceFactory.UpdateAssociatedUserBusiness().edit(query);

        if (update.getRecords() < 1) {
            process.addLog(pLogger.ERROR("Modificar asociación Usuario y Cliente", "Error al asociar usuario a empresa: " + update.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Modificar asociación Usuario y Cliente", "Asociación editada correctamente: " + update.getResult().getId()));

    }

}
