package com.personal.business.orgrelation.update.process;

import com.personal.business.orgrelation.entities.OrgRelation;
import com.personal.business.orgrelation.update.process.rules.UpdateFieldsParamsOrgRelationRule;
import com.personal.business.orgrelation.update.process.rules.UpdateOrgRelationRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateOrgRelationProcessExecutor extends SupplierProcessExecutor<UpdateOrgRelationProcess, OrgRelation> {

    public UpdateOrgRelationProcessExecutor() {
        super(new UpdateOrgRelationProcess(),
                UpdateFieldsParamsOrgRelationRule::new,
                UpdateOrgRelationRule::new
        );
    }

    public static UpdateOrgRelationProcessExecutor builder() {
        return new UpdateOrgRelationProcessExecutor();
    }

}
