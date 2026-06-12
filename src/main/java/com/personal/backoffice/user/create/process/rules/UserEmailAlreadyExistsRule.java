package com.personal.backoffice.user.create.process.rules;

import com.personal.backoffice.user.create.process.CreateUserProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;
import com.personal.shared.query.Query;

public class UserEmailAlreadyExistsRule implements IProcessRule<CreateUserProcess> {

    @Override
    public void apply(CreateUserProcess process) {
        var pLogger = LogFactory.builder(CreateUserProcess.class, UserEmailAlreadyExistsRule.class);

        var user = process.getInitObject();

        var query = new Query();
        query.Field("us_email", user.getEmail());
        query.Where().Equ("us_email");

        var userByEmail = UserServiceFactory.FilterUser().filter(query);

        if (userByEmail.getResult() == null || userByEmail.getResult().isEmpty()) {
            process.addLog(pLogger.INFO("Crear usuario", "User email is available: " + user.getEmail()));
            return;
        }
        process.addLog(pLogger.WARNING("Crear usuario", "User email already exists: " + user.getEmail()));
        process.stop();

    }

}
