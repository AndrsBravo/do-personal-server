package com.personal.backoffice.register.login.process.rules;

import com.personal.backoffice.register.login.process.LoginProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class LoginUserRule implements IProcessRule<LoginProcess> {

    @Override
    public void apply(LoginProcess process) {
        var pLogger = LogFactory.builder(LoginProcess.class, LoginUserRule.class);
        var user = process.getInitObject();

        var query = process.Query();
        query.Field("us_email", user.getEmail());
        query.Where().Equ("us_email");
        query.Field("us_name", user.getUserName());
        query.Where().OrEqu("us_name");

        var userByEmailForLogin = UserServiceFactory.FilterUser().filter(query);

        if (userByEmailForLogin.getRecords() < 1) {
            process.addLog(pLogger.WARNING("Login by email", "User not found with email: " + user.getEmail()));
            process.stop();
            return;
        }
        process.addLog(pLogger.INFO("Login by email", "User found with email: " + user.getEmail()));
    }

}
