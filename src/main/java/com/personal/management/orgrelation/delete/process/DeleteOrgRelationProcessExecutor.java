package com.personal.management.orgrelation.delete.process;

import com.personal.management.orgrelation.delete.process.rules.DeleteOrgRelationRule;
import com.personal.management.orgrelation.entities.OrgRelation;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteOrgRelationProcessExecutor extends SupplierProcessExecutor<DeleteOrgRelationProcess, OrgRelation> {

    public DeleteOrgRelationProcessExecutor() {
        super(new DeleteOrgRelationProcess(),
                DeleteOrgRelationRule::new
        );
    }

    public static DeleteOrgRelationProcessExecutor builder() {
        return new DeleteOrgRelationProcessExecutor();
    }

}
