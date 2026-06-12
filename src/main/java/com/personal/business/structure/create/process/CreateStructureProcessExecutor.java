package com.personal.business.structure.create.process;

import com.personal.business.structure.create.process.rules.CreateStructureRule;
import com.personal.business.structure.create.process.rules.ValidateStructureRule;
import com.personal.business.structure.entities.Structure;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateStructureProcessExecutor extends SupplierProcessExecutor<CreateStructureProcess, Structure> {

    public CreateStructureProcessExecutor() {
        super(new CreateStructureProcess(),
                ValidateStructureRule::new,
                CreateStructureRule::new
        );
    }

    public static CreateStructureProcessExecutor builder() {
        return new CreateStructureProcessExecutor();
    }

}
