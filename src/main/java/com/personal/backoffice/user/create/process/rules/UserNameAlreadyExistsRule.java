package com.personal.backoffice.user.create.process.rules;

import com.personal.backoffice.user.create.process.CreateUserProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;
import com.personal.shared.query.Query;

public class UserNameAlreadyExistsRule implements IProcessRule<CreateUserProcess> {

    @Override
    public void apply(CreateUserProcess process) {

        var pLogger = LogFactory.builder(CreateUserProcess.class, UserNameAlreadyExistsRule.class);

        var user = process.getInitObject();

        var query = new Query();
        query.Field("user_name", user.getUserName());
        query.Where().Equ("user_name");

        var userByUserName = UserServiceFactory.FilterUser().filter(query);

        if (userByUserName.getResult() == null || userByUserName.getResult().isEmpty()) {
            process.addLog(pLogger.INFO("Crear usuario", "User name is available: " + user.getUserName()));
            return;
        }

        process.addLog(pLogger.WARNING("Crear usuario", "User name already exists: " + user.getUserName()));
        process.stop();

    }

}
