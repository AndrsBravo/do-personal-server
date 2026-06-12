package com.personal.backoffice.register.login.process;

import com.personal.backoffice.register.login.process.rules.LoginUserRule;
import com.personal.backoffice.register.login.process.rules.VerifyUserPasswordRule;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.process.SupplierProcessExecutor;

public class LoginProcessExecutor extends SupplierProcessExecutor<LoginProcess, User> {

    public LoginProcessExecutor() {
        super(new LoginProcess(),
                LoginUserRule::new,
                VerifyUserPasswordRule::new);
    }

    public static LoginProcessExecutor builder() {
        return new LoginProcessExecutor();
    }

}
