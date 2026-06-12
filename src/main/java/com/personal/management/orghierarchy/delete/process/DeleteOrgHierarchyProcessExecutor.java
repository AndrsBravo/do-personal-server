package com.personal.management.orghierarchy.delete.process;

import com.personal.management.orghierarchy.delete.process.rules.DeleteOrgHierarchyRule;
import com.personal.management.orghierarchy.entities.OrgHierarchy;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteOrgHierarchyProcessExecutor extends SupplierProcessExecutor<DeleteOrgHierarchyProcess, OrgHierarchy> {

    public DeleteOrgHierarchyProcessExecutor() {
        super(new DeleteOrgHierarchyProcess(),
                DeleteOrgHierarchyRule::new
        );
    }

    public static DeleteOrgHierarchyProcessExecutor builder() {
        return new DeleteOrgHierarchyProcessExecutor();
    }

}
