package com.personal.business.structure.update.process;

import com.personal.business.structure.entities.Structure;
import com.personal.business.structure.update.process.rules.UpdateFieldsParamsStructureRule;
import com.personal.business.structure.update.process.rules.UpdateStructureRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateStructureProcessExecutor extends SupplierProcessExecutor<UpdateStructureProcess, Structure> {

    public UpdateStructureProcessExecutor() {
        super(new UpdateStructureProcess(),
                UpdateFieldsParamsStructureRule::new,
                UpdateStructureRule::new
        );
    }

    public static UpdateStructureProcessExecutor builder() {
        return new UpdateStructureProcessExecutor();
    }

}
