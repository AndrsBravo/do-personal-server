package com.personal.business.orghierarchy.delete.process;

import com.personal.business.orghierarchy.delete.process.rules.DeleteOrgHierarchyRule;
import com.personal.business.orghierarchy.entities.OrgHierarchy;
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
