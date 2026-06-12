package com.personal.business.hierarchydeductionfeed.create.process;

import com.personal.business.hierarchydeductionfeed.create.process.rules.CreateHierarchyDeductionFeedRule;
import com.personal.business.hierarchydeductionfeed.create.process.rules.ValidateHierarchyDeductionFeedRule;
import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateHierarchyDeductionFeedProcessExecutor extends SupplierProcessExecutor<CreateHierarchyDeductionFeedProcess, HierarchyDeductionFeed> {

    public CreateHierarchyDeductionFeedProcessExecutor() {
        super(new CreateHierarchyDeductionFeedProcess(),
                ValidateHierarchyDeductionFeedRule::new,
                CreateHierarchyDeductionFeedRule::new
        );
    }

    public static CreateHierarchyDeductionFeedProcessExecutor builder() {
        return new CreateHierarchyDeductionFeedProcessExecutor();
    }

}
