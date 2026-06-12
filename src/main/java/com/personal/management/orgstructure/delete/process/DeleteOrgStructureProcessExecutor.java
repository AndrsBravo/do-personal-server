package com.personal.management.orgstructure.delete.process;

import com.personal.management.orgstructure.delete.process.rules.DeleteOrgStructureRule;
import com.personal.management.orgstructure.entities.OrgStructure;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteOrgStructureProcessExecutor extends SupplierProcessExecutor<DeleteOrgStructureProcess, OrgStructure> {

    public DeleteOrgStructureProcessExecutor() {
        super(new DeleteOrgStructureProcess(),
                DeleteOrgStructureRule::new
        );
    }

    public static DeleteOrgStructureProcessExecutor builder() {
        return new DeleteOrgStructureProcessExecutor();
    }

}
