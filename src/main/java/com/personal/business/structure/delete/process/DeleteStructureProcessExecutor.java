package com.personal.business.structure.delete.process;

import com.personal.business.structure.delete.process.rules.DeleteStructureRule;
import com.personal.business.structure.entities.Structure;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteStructureProcessExecutor extends SupplierProcessExecutor<DeleteStructureProcess, Structure> {

    public DeleteStructureProcessExecutor() {
        super(new DeleteStructureProcess(),
                DeleteStructureRule::new
        );
    }

    public static DeleteStructureProcessExecutor builder() {
        return new DeleteStructureProcessExecutor();
    }

}
