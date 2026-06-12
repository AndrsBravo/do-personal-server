package com.personal.backoffice.register.login.process;

import com.personal.backoffice.user.entities.User;
import com.personal.shared.process.SupplierProcess;

public class LoginProcess extends SupplierProcess<User> {

    public LoginProcess() {
        super("login_by_email_process");
    }
}
