package com.personal.business.user.create.process.rules;

import com.personal.business.user.create.process.CreateUserProcess;
import com.personal.business.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateUserRule implements IProcessRule<CreateUserProcess> {

    @Override
    public void apply(CreateUserProcess process) {

        var pLogger = LogFactory.builder(CreateUserProcess.class, CreateUserRule.class);
        var query = process.Query();

        var user = process.getInitObject();

        query.Field("id", user.getId());
        query.Field("us_created_by", user.getCreatedBy().getId());
        query.Field("us_created_at", user.getCreatedAt().toString());
        query.Field("us_updated_at", user.getUpdatedAt().toString());

        var create = UserServiceFactory.CreateUser(user.getBusiness().getDbName()).create(query);

        if (create.getRecords() < 1) {
            process.addLog(pLogger.ERROR("Crear usuario", "Failed to create user: " + create.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear usuario", "User created successfully: " + create.getResult().getId()));

    }

}
