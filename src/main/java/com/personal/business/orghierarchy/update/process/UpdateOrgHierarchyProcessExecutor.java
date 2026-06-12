package com.personal.business.orghierarchy.update.process;

import com.personal.business.orghierarchy.entities.OrgHierarchy;
import com.personal.business.orghierarchy.update.process.rules.UpdateFieldsParamsOrgHierarchyRule;
import com.personal.business.orghierarchy.update.process.rules.UpdateOrgHierarchyRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateOrgHierarchyProcessExecutor extends SupplierProcessExecutor<UpdateOrgHierarchyProcess, OrgHierarchy> {

    public UpdateOrgHierarchyProcessExecutor() {
        super(new UpdateOrgHierarchyProcess(),
                UpdateFieldsParamsOrgHierarchyRule::new,
                UpdateOrgHierarchyRule::new
        );
    }

    public static UpdateOrgHierarchyProcessExecutor builder() {
        return new UpdateOrgHierarchyProcessExecutor();
    }

}
