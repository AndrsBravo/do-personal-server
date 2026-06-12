package com.personal.business.orgstructure.create.process;

import com.personal.business.orgstructure.create.process.rules.CreateOrgStructureRule;
import com.personal.business.orgstructure.create.process.rules.ValidateOrgStructureRule;
import com.personal.business.orgstructure.entities.OrgStructure;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateOrgStructureProcessExecutor extends SupplierProcessExecutor<CreateOrgStructureProcess, OrgStructure> {

    public CreateOrgStructureProcessExecutor() {
        super(new CreateOrgStructureProcess(),
                ValidateOrgStructureRule::new,
                CreateOrgStructureRule::new
        );
    }

    public static CreateOrgStructureProcessExecutor builder() {
        return new CreateOrgStructureProcessExecutor();
    }

}
