package com.personal.backoffice.user.create.process;

import com.personal.backoffice.user.create.process.rules.CreateUserRule;
import com.personal.backoffice.user.create.process.rules.UserEmailAlreadyExistsRule;
import com.personal.backoffice.user.create.process.rules.UserNameAlreadyExistsRule;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateUserProcessExecutor extends SupplierProcessExecutor<CreateUserProcess, User> {

    public CreateUserProcessExecutor() {

        super(new CreateUserProcess(),
                UserEmailAlreadyExistsRule::new,
                UserNameAlreadyExistsRule::new,
                CreateUserRule::new
        );
    }

    public static CreateUserProcessExecutor builder() {
        return new CreateUserProcessExecutor();
    }

}
