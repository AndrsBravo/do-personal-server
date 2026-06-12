package com.personal.backoffice.commercial.entity.create.process;

import com.personal.backoffice.commercial.entity.create.process.rules.CreateCommercialEntityRule;
import com.personal.backoffice.commercial.entity.create.process.rules.ValidateCommercialEntityRule;
import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateCommercialEntityProcessExecutor extends SupplierProcessExecutor<CreateCommercialEntityProcess, CommercialEntity> {

    public CreateCommercialEntityProcessExecutor() {
        super(new CreateCommercialEntityProcess(),
                ValidateCommercialEntityRule::new,
                CreateCommercialEntityRule::new
        );
    }

    public static CreateCommercialEntityProcessExecutor builder() {
        return new CreateCommercialEntityProcessExecutor();
    }

}
