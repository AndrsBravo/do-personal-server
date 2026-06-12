package com.personal.business.orgrelation.create.process;

import com.personal.business.orgrelation.create.process.rules.CreateOrgRelationRule;
import com.personal.business.orgrelation.create.process.rules.ValidateOrgRelationRule;
import com.personal.business.orgrelation.entities.OrgRelation;
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
