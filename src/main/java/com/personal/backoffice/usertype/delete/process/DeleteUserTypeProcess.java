package com.personal.backoffice.usertype.delete.process;

import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.SupplierProcess;

public class DeleteUserTypeProcess extends SupplierProcess<TypeEntityBase> {

    public DeleteUserTypeProcess() {
        super("delete_user_type_process");
    }

}
