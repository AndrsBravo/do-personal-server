package com.personal.backoffice.client.delete.process;

import com.personal.backoffice.client.entities.Client;
import com.personal.shared.process.SupplierProcess;

public class DeleteClientProcess extends SupplierProcess<Client> {

    public DeleteClientProcess() {
        super("delete_client_process");
    }

}
