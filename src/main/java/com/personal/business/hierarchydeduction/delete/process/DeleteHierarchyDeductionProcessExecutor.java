package com.personal.business.hierarchydeduction.delete.process;

import com.personal.business.hierarchydeduction.delete.process.rules.DeleteHierarchyDeductionRule;
import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteHierarchyDeductionProcessExecutor extends SupplierProcessExecutor<DeleteHierarchyDeductionProcess, HierarchyDeduction> {

    public DeleteHierarchyDeductionProcessExecutor() {
        super(new DeleteHierarchyDeductionProcess(),
                DeleteHierarchyDeductionRule::new
        );
    }

    public static DeleteHierarchyDeductionProcessExecutor builder() {
        return new DeleteHierarchyDeductionProcessExecutor();
    }

}
