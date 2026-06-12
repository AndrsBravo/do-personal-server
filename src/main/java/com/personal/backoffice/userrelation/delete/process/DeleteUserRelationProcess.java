package com.personal.backoffice.userrelation.delete.process;

import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.shared.process.SupplierProcess;

public class DeleteUserRelationProcess extends SupplierProcess<UserRelation> {

    public DeleteUserRelationProcess() {
        super("delete_user_relation_process");
    }

}
