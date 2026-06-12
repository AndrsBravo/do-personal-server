package com.personal.backoffice.usertype.create.process;

import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.SupplierProcess;

public class CreateUserTypeProcess extends SupplierProcess<TypeEntityBase> {

    public CreateUserTypeProcess() {
        super("create_user_type_process");
    }

}
