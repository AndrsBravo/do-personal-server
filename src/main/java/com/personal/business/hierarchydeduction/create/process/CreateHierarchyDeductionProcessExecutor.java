package com.personal.business.hierarchydeduction.create.process;

import com.personal.business.hierarchydeduction.create.process.rules.CreateHierarchyDeductionRule;
import com.personal.business.hierarchydeduction.create.process.rules.ValidateHierarchyDeductionRule;
import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateHierarchyDeductionProcessExecutor extends SupplierProcessExecutor<CreateHierarchyDeductionProcess, HierarchyDeduction> {

    public CreateHierarchyDeductionProcessExecutor() {
        super(new CreateHierarchyDeductionProcess(),
                ValidateHierarchyDeductionRule::new,
                CreateHierarchyDeductionRule::new
        );
    }

    public static CreateHierarchyDeductionProcessExecutor builder() {
        return new CreateHierarchyDeductionProcessExecutor();
    }

}
