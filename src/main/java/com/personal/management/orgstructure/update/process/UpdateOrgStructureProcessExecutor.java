package com.personal.management.orgstructure.update.process;

import com.personal.management.orgstructure.entities.OrgStructure;
import com.personal.management.orgstructure.update.process.rules.UpdateFieldsParamsOrgStructureRule;
import com.personal.management.orgstructure.update.process.rules.UpdateOrgStructureRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateOrgStructureProcessExecutor extends SupplierProcessExecutor<UpdateOrgStructureProcess, OrgStructure> {

    public UpdateOrgStructureProcessExecutor() {
        super(new UpdateOrgStructureProcess(),
                UpdateFieldsParamsOrgStructureRule::new,
                UpdateOrgStructureRule::new
        );
    }

    public static UpdateOrgStructureProcessExecutor builder() {
        return new UpdateOrgStructureProcessExecutor();
    }

}
