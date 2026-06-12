package com.personal.business.user.create.process;

import com.personal.business.user.entities.User;
import com.personal.shared.process.SupplierProcess;

public class CreateUserProcess extends SupplierProcess<User> {

    public CreateUserProcess() {
        super("create_user_process");
    }

}
