package com.personal.backoffice.commercial.entity.delete.process;

import com.personal.backoffice.commercial.entity.delete.process.rules.DeleteCommercialEntityRule;
import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteCommercialEntityProcessExecutor extends SupplierProcessExecutor<DeleteCommercialEntityProcess, CommercialEntity> {

    public DeleteCommercialEntityProcessExecutor() {
        super(new DeleteCommercialEntityProcess(),
                DeleteCommercialEntityRule::new
        );
    }

    public static DeleteCommercialEntityProcessExecutor builder() {
        return new DeleteCommercialEntityProcessExecutor();
    }

}
