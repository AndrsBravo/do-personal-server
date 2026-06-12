package com.personal.business.orgrelation.delete.process;

import com.personal.business.orgrelation.delete.process.rules.DeleteOrgRelationRule;
import com.personal.business.orgrelation.entities.OrgRelation;
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
