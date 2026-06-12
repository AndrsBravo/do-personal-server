package com.personal.backoffice.register.password.process;

import com.personal.backoffice.register.password.inputs.UserCredentialsInput;
import com.personal.backoffice.register.password.process.rules.EncryptUserPasswordRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateUserCredentialsProcessExecutor extends SupplierProcessExecutor<CreateUserCredentialsProcess, UserCredentialsInput> {

    public CreateUserCredentialsProcessExecutor() {
        super(new CreateUserCredentialsProcess(),
                EncryptUserPasswordRule::new);
    }

    public static CreateUserCredentialsProcessExecutor builder() {
        return new CreateUserCredentialsProcessExecutor();
    }

}
