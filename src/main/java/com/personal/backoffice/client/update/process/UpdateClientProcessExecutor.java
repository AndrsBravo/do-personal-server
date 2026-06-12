package com.personal.backoffice.client.update.process;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.client.update.process.rules.UpdateClientRule;
import com.personal.backoffice.client.update.process.rules.UpdateFieldsParamsClientsRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateClientProcessExecutor extends SupplierProcessExecutor<UpdateClientProcess, Client> {

    public UpdateClientProcessExecutor() {
        super(new UpdateClientProcess(),
                UpdateFieldsParamsClientsRule::new,
                UpdateClientRule::new
        );
    }

    public static UpdateClientProcessExecutor builder() {
        return new UpdateClientProcessExecutor();
    }

}
