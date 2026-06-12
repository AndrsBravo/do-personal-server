package com.personal.backoffice.register.password.process;

import com.personal.backoffice.register.password.inputs.UserCredentialsInput;
import com.personal.shared.process.SupplierProcess;

public class CreateUserCredentialsProcess extends SupplierProcess<UserCredentialsInput> {

    public CreateUserCredentialsProcess() {
        super("create_user_credentials_process");
    }
}
