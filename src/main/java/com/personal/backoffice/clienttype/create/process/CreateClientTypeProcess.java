package com.personal.backoffice.clienttype.create.process;

import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.SupplierProcess;

public class CreateClientTypeProcess extends SupplierProcess<TypeEntityBase> {

    public CreateClientTypeProcess() {
        super("create_client_type_process");
    }

}
