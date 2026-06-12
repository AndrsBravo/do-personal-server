package com.personal.backoffice.register.password.process.rules;

import com.personal.backoffice.register.factories.UserRegisterServiceFactory;
import com.personal.backoffice.register.password.process.CreateUserCredentialsProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class EncryptUserPasswordRule implements IProcessRule<CreateUserCredentialsProcess> {

    @Override
    public void apply(CreateUserCredentialsProcess process) {
        var pLogger = LogFactory.builder(CreateUserCredentialsProcess.class, EncryptUserPasswordRule.class);

        var user = process.getInitObject();

        var credentials = UserRegisterServiceFactory.EncryptPasswordService().encryptPassword(user.getPassword());

        user.setCredentials(credentials);
        process.addLog(pLogger.INFO("Crear usuario", "User password encrypted"));
    }

}
