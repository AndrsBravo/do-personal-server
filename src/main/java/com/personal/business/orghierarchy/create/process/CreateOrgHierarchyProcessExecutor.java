package com.personal.business.orghierarchy.create.process;

import com.personal.business.orghierarchy.create.process.rules.CreateOrgHierarchyRule;
import com.personal.business.orghierarchy.create.process.rules.ValidateOrgHierarchyRule;
import com.personal.business.orghierarchy.entities.OrgHierarchy;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateOrgHierarchyProcessExecutor extends SupplierProcessExecutor<CreateOrgHierarchyProcess, OrgHierarchy> {

    public CreateOrgHierarchyProcessExecutor() {
        super(new CreateOrgHierarchyProcess(),
                ValidateOrgHierarchyRule::new,
                CreateOrgHierarchyRule::new
        );
    }

    public static CreateOrgHierarchyProcessExecutor builder() {
        return new CreateOrgHierarchyProcessExecutor();
    }

}
