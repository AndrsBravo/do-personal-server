package com.personal.business.user.create.process;

import com.personal.business.user.create.process.rules.CreateUserRule;
import com.personal.business.user.create.process.rules.UserAlreadyExistsRule;
import com.personal.business.user.entities.User;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateUserProcessExecutor extends SupplierProcessExecutor<CreateUserProcess, User> {

    public CreateUserProcessExecutor() {

        super(new CreateUserProcess(),
                UserAlreadyExistsRule::new,
                CreateUserRule::new
        );
    }

    public static CreateUserProcessExecutor builder() {
        return new CreateUserProcessExecutor();
    }

}
