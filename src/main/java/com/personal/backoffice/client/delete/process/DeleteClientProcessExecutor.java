package com.personal.backoffice.client.delete.process;

import com.personal.backoffice.client.delete.process.rules.DeleteClientRule;
import com.personal.backoffice.client.entities.Client;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteClientProcessExecutor extends SupplierProcessExecutor<DeleteClientProcess, Client> {

    public DeleteClientProcessExecutor() {
        super(new DeleteClientProcess(),
                DeleteClientRule::new
        );
    }

    public static DeleteClientProcessExecutor builder() {
        return new DeleteClientProcessExecutor();
    }

}
