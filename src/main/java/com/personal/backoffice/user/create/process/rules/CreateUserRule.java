package com.personal.backoffice.user.create.process.rules;

import com.personal.backoffice.user.create.process.CreateUserProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateUserRule implements IProcessRule<CreateUserProcess> {

    @Override
    public void apply(CreateUserProcess process) {

        var pLogger = LogFactory.builder(CreateUserProcess.class, CreateUserRule.class);
        var query = process.Query();
        var user = process.getInitObject();
        query.Field("id", user.getId());
        query.Field("user_types_id", user.getUserType().getId());
        query.Field("user_name", user.getUserName());
        query.Field("us_name", user.getNames());
        query.Field("us_last_name", user.getLastNames());
        query.Field("us_email", user.getEmail());
        query.Field("us_created_by", user.getCreatedBy().getId());

        var create = UserServiceFactory.CreateUser().create(query);

        if (create.getRecords() < 1) {
            process.addLog(pLogger.ERROR("Crear usuario", "Failed to create user: " + create.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear usuario", "User created successfully: " + user.getId()));

    }

}
