package com.personal.backoffice.register.login.process.rules;

import com.personal.backoffice.register.factories.UserRegisterServiceFactory;
import com.personal.backoffice.register.login.process.LoginProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class VerifyUserPasswordRule implements IProcessRule<LoginProcess> {

    @Override
    public void apply(LoginProcess process) {
        var pLogger = LogFactory.builder(LoginProcess.class, VerifyUserPasswordRule.class);
        var user = process.getInitObject();

        var verified = UserRegisterServiceFactory.VerifyPasswordService().verify(user);

        if (!verified) {
            process.addLog(pLogger.WARNING("Verify password", "Invalid password for user: " + user.getEmail()));
            process.stop();
            return;
        }

        process.addLog(pLogger.INFO("Verify password", "Password verified successfully for user: " + user.getEmail()));
    }

}
