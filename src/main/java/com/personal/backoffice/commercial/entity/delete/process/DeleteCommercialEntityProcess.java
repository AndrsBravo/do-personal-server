package com.personal.backoffice.commercial.entity.delete.process;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.shared.process.SupplierProcess;

public class DeleteCommercialEntityProcess extends SupplierProcess<CommercialEntity> {

    public DeleteCommercialEntityProcess() {
        super("delete_commercial_entity_process");
    }

}
