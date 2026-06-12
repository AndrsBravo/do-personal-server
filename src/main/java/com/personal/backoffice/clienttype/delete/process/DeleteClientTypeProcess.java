package com.personal.backoffice.clienttype.delete.process;

import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.SupplierProcess;

public class DeleteClientTypeProcess extends SupplierProcess<TypeEntityBase> {

    public DeleteClientTypeProcess() {
        super("delete_client_type_process");
    }

}
