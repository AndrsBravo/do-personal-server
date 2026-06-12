package com.personal.backoffice.commercial.entity.update.process;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.commercial.entity.update.process.rules.UpdateCommercialEntityRule;
import com.personal.backoffice.commercial.entity.update.process.rules.UpdateFieldsParamsCommercialEntityRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateCommercialEntityProcessExecutor extends SupplierProcessExecutor<UpdateCommercialEntityProcess, CommercialEntity> {

    public UpdateCommercialEntityProcessExecutor() {
        super(new UpdateCommercialEntityProcess(),
                UpdateFieldsParamsCommercialEntityRule::new,
                UpdateCommercialEntityRule::new
        );
    }

    public static UpdateCommercialEntityProcessExecutor builder() {
        return new UpdateCommercialEntityProcessExecutor();
    }

}
