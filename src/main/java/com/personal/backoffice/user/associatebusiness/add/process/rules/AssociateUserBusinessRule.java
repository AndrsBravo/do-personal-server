package com.personal.backoffice.user.associatebusiness.add.process.rules;

import com.personal.backoffice.user.associatebusiness.add.process.AssociateUserBusinessProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class AssociateUserBusinessRule implements IProcessRule<AssociateUserBusinessProcess> {

    @Override
    public void apply(AssociateUserBusinessProcess process) {

        var pLogger = LogFactory.builder(AssociateUserBusinessProcess.class, AssociateUserBusinessRule.class);
        var associateUserBusiness = UserServiceFactory.AssociateUserBusiness();
        var result = associateUserBusiness.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Asociando Usuario a Cliente", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Asociando Usuario a Cliente", "Usuario asociado a la empresa con éxito"));

    }

}
