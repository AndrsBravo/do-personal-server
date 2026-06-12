package com.personal.backoffice.usertype.delete.process;

import com.personal.backoffice.usertype.delete.process.rules.DeleteUserTypeRule;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteUserTypeProcessExecutor extends SupplierProcessExecutor<DeleteUserTypeProcess, TypeEntityBase> {

    public DeleteUserTypeProcessExecutor() {
        super(new DeleteUserTypeProcess(),
                DeleteUserTypeRule::new
        );
    }

    public static DeleteUserTypeProcessExecutor builder() {
        return new DeleteUserTypeProcessExecutor();
    }

}
