package com.personal.business.hierarchy.create.process;

import com.personal.business.hierarchy.create.process.rules.CreateHierarchyRule;
import com.personal.business.hierarchy.create.process.rules.ValidateHierarchyRule;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateHierarchyProcessExecutor extends SupplierProcessExecutor<CreateHierarchyProcess, Hierarchy> {

    public CreateHierarchyProcessExecutor() {
        super(new CreateHierarchyProcess(),
                ValidateHierarchyRule::new,
                CreateHierarchyRule::new
        );
    }

    public static CreateHierarchyProcessExecutor builder() {
        return new CreateHierarchyProcessExecutor();
    }

}
