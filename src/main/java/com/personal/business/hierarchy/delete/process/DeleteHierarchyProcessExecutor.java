package com.personal.business.hierarchy.delete.process;

import com.personal.business.hierarchy.delete.process.rules.DeleteHierarchyRule;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteHierarchyProcessExecutor extends SupplierProcessExecutor<DeleteHierarchyProcess, Hierarchy> {

    public DeleteHierarchyProcessExecutor() {
        super(new DeleteHierarchyProcess(),
                DeleteHierarchyRule::new
        );
    }

    public static DeleteHierarchyProcessExecutor builder() {
        return new DeleteHierarchyProcessExecutor();
    }

}
