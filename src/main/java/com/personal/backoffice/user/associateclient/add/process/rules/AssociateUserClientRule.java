package com.personal.backoffice.user.associateclient.add.process.rules;

import com.personal.backoffice.user.associateclient.add.process.AssociateUserClientProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class AssociateUserClientRule implements IProcessRule<AssociateUserClientProcess> {

    @Override
    public void apply(AssociateUserClientProcess process) {

        var pLogger = LogFactory.builder(AssociateUserClientProcess.class, AssociateUserClientRule.class);
        var associateUserClient = UserServiceFactory.AssociateUserClient();
        var result = associateUserClient.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Asociando Usuario a Cliente", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Asociando Usuario a Cliente", "Usuario asociado al cliente con éxito"));

    }

}
