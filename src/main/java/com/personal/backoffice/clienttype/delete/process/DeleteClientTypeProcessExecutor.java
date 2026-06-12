package com.personal.backoffice.clienttype.delete.process;

import com.personal.backoffice.clienttype.delete.process.rules.DeleteClientTypeRule;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteClientTypeProcessExecutor extends SupplierProcessExecutor<DeleteClientTypeProcess, TypeEntityBase> {

    public DeleteClientTypeProcessExecutor() {
        super(new DeleteClientTypeProcess(),
                DeleteClientTypeRule::new
        );
    }

    public static DeleteClientTypeProcessExecutor builder() {
        return new DeleteClientTypeProcessExecutor();
    }

}
