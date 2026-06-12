package com.personal.backoffice.client.update.process;

import com.personal.backoffice.client.entities.Client;
import com.personal.shared.process.SupplierProcess;

public class UpdateClientProcess extends SupplierProcess<Client> {

    public UpdateClientProcess() {
        super("update_client_process");
    }

}
