package com.personal.backoffice.client.create.process;

import com.personal.backoffice.client.create.process.rules.AssociateUserClientRule;
import com.personal.backoffice.client.create.process.rules.CreateClientRule;
import com.personal.backoffice.client.create.process.rules.ValidateClientRule;
import com.personal.backoffice.client.create.process.rules.ValidateUserClientRelationRule;
import com.personal.backoffice.client.create.process.rules.ValidateUserClientRoleRule;
import com.personal.backoffice.client.entities.Client;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateClientProcessExecutor extends SupplierProcessExecutor<CreateClientProcess, Client> {

    public CreateClientProcessExecutor() {
        super(new CreateClientProcess(),
                ValidateClientRule::new,
                CreateClientRule::new,
                ValidateUserClientRoleRule::new,
                ValidateUserClientRelationRule::new,
                AssociateUserClientRule::new
        );
    }

    public static CreateClientProcessExecutor builder() {
        return new CreateClientProcessExecutor();
    }

}
