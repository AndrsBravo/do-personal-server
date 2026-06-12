package com.personal.backoffice.clienttype.create.process;

import com.personal.backoffice.clienttype.create.process.rules.CreateClientTypeRule;
import com.personal.backoffice.clienttype.create.process.rules.ValidateClientTypeRule;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateClientTypeProcessExecutor extends SupplierProcessExecutor<CreateClientTypeProcess, TypeEntityBase> {

    public CreateClientTypeProcessExecutor() {
        super(new CreateClientTypeProcess(),
                ValidateClientTypeRule::new,
                CreateClientTypeRule::new
        );
    }

    public static CreateClientTypeProcessExecutor builder() {
        return new CreateClientTypeProcessExecutor();
    }

}
