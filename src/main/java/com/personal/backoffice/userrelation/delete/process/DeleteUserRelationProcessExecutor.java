package com.personal.backoffice.userrelation.delete.process;

import com.personal.backoffice.userrelation.delete.process.rules.DeleteUserRelationRule;
import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteUserRelationProcessExecutor extends SupplierProcessExecutor<DeleteUserRelationProcess, UserRelation> {

    public DeleteUserRelationProcessExecutor() {
        super(new DeleteUserRelationProcess(),
                DeleteUserRelationRule::new
        );
    }

    public static DeleteUserRelationProcessExecutor builder() {
        return new DeleteUserRelationProcessExecutor();
    }

}
