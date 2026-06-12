package com.personal.management.orgrelation.create.process;

import com.personal.management.orgrelation.create.process.rules.CreateOrgRelationRule;
import com.personal.management.orgrelation.create.process.rules.ValidateOrgRelationRule;
import com.personal.management.orgrelation.entities.OrgRelation;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateOrgRelationProcessExecutor extends SupplierProcessExecutor<CreateOrgRelationProcess, OrgRelation> {

    public CreateOrgRelationProcessExecutor() {
        super(new CreateOrgRelationProcess(),
                ValidateOrgRelationRule::new,
                CreateOrgRelationRule::new
        );
    }

    public static CreateOrgRelationProcessExecutor builder() {
        return new CreateOrgRelationProcessExecutor();
    }

}
