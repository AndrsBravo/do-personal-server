package com.personal.business.hierarchydeduction.update.process;

import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.business.hierarchydeduction.update.process.rules.UpdateHierarchyDeductionRule;
import com.personal.business.hierarchydeduction.update.process.rules.UpdateFieldsParamsHierarchyDeductionRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateHierarchyDeductionProcessExecutor extends SupplierProcessExecutor<UpdateHierarchyDeductionProcess, HierarchyDeduction> {

    public UpdateHierarchyDeductionProcessExecutor() {
        super(new UpdateHierarchyDeductionProcess(),
                UpdateFieldsParamsHierarchyDeductionRule::new,
                UpdateHierarchyDeductionRule::new
        );
    }

    public static UpdateHierarchyDeductionProcessExecutor builder() {
        return new UpdateHierarchyDeductionProcessExecutor();
    }

}
