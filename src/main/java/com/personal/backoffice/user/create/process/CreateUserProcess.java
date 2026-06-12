package com.personal.backoffice.user.create.process;

import com.personal.backoffice.user.entities.User;
import com.personal.shared.process.SupplierProcess;

public class CreateUserProcess extends SupplierProcess<User> {

    public CreateUserProcess() {
        super("create_user_process");
    }

}
