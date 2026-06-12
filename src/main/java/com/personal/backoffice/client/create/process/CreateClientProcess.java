package com.personal.backoffice.client.create.process;

import com.personal.backoffice.client.entities.Client;
import com.personal.shared.process.SupplierProcess;

public class CreateClientProcess extends SupplierProcess<Client> {

    public CreateClientProcess() {
        super("create_client_process");
    }

}
