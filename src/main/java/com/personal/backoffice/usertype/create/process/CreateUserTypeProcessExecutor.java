package com.personal.backoffice.usertype.create.process;

import com.personal.backoffice.usertype.create.process.rules.CreateUserTypeRule;
import com.personal.backoffice.usertype.create.process.rules.ValidateUserTypeRule;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateUserTypeProcessExecutor extends SupplierProcessExecutor<CreateUserTypeProcess, TypeEntityBase> {

    public CreateUserTypeProcessExecutor() {
        super(new CreateUserTypeProcess(),
                ValidateUserTypeRule::new,
                CreateUserTypeRule::new
        );
    }

    public static CreateUserTypeProcessExecutor builder() {
        return new CreateUserTypeProcessExecutor();
    }

}
