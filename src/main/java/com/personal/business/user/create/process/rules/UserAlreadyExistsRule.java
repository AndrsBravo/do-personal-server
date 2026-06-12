package com.personal.business.user.create.process.rules;

import com.personal.business.user.create.process.CreateUserProcess;
import com.personal.business.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;
import com.personal.shared.query.Query;

public class UserAlreadyExistsRule implements IProcessRule<CreateUserProcess> {

    @Override
    public void apply(CreateUserProcess process) {

        var pLogger = LogFactory.builder(CreateUserProcess.class, UserAlreadyExistsRule.class);

        var user = process.getInitObject();

        var query = new Query();
        query.Field("id", user.getId());
        query.Where().Equ("id");

        var userByUserName = UserServiceFactory.FilterUser(user.getBusiness().getDbName()).filter(query);

        if (userByUserName.getResult() == null || userByUserName.getResult().isEmpty()) {
            process.addLog(pLogger.INFO("Validar usuario", "El usuario está disponible: " + user.getId()));
            return;
        }

        process.addLog(pLogger.WARNING("Validar usuario", "El nombre de usuario ya existe: " + user.getId()));
        process.stop();

    }

}
