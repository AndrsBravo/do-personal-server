package com.personal.backoffice.userrelation.update.process;

import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.backoffice.userrelation.update.process.rules.UpdateFieldsParamsUserRelationsRule;
import com.personal.backoffice.userrelation.update.process.rules.UpdateUserRelationRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateUserRelationProcessExecutor extends SupplierProcessExecutor<UpdateUserRelationProcess, UserRelation> {

    public UpdateUserRelationProcessExecutor() {
        super(new UpdateUserRelationProcess(),
                UpdateFieldsParamsUserRelationsRule::new,
                UpdateUserRelationRule::new
        );
    }

    public static UpdateUserRelationProcessExecutor builder() {
        return new UpdateUserRelationProcessExecutor();
    }

}
