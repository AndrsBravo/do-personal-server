package com.personal.backoffice.userrelation.create.process;

import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.shared.process.SupplierProcess;

public class CreateUserRelationProcess extends SupplierProcess<UserRelation> {

    public CreateUserRelationProcess() {
        super("create_user_relation_process");
    }

}
