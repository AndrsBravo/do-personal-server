package com.personal.backoffice.userrelation.create.process;

import com.personal.backoffice.userrelation.create.process.rules.CreateUserRelationRule;
import com.personal.backoffice.userrelation.create.process.rules.ValidateUserRelationRule;
import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateUserRelationProcessExecutor extends SupplierProcessExecutor<CreateUserRelationProcess, UserRelation> {

    public CreateUserRelationProcessExecutor() {
        super(new CreateUserRelationProcess(),
                ValidateUserRelationRule::new,
                CreateUserRelationRule::new
        );
    }

    public static CreateUserRelationProcessExecutor builder() {
        return new CreateUserRelationProcessExecutor();
    }

}
