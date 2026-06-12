package com.personal.business.hierarchy.update.process;

import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchy.update.process.rules.UpdateFieldsParamsHierarchyRule;
import com.personal.business.hierarchy.update.process.rules.UpdateHierarchyRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateHierarchyProcessExecutor extends SupplierProcessExecutor<UpdateHierarchyProcess, Hierarchy> {

    public UpdateHierarchyProcessExecutor() {
        super(new UpdateHierarchyProcess(),
                UpdateFieldsParamsHierarchyRule::new,
                UpdateHierarchyRule::new
        );
    }

    public static UpdateHierarchyProcessExecutor builder() {
        return new UpdateHierarchyProcessExecutor();
    }

}
