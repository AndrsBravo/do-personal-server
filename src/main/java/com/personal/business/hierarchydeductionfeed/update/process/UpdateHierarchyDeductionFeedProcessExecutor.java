package com.personal.business.hierarchydeductionfeed.update.process;

import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;
import com.personal.business.hierarchydeductionfeed.update.process.rules.UpdateHierarchyDeductionFeedRule;
import com.personal.business.hierarchydeductionfeed.update.process.rules.UpdateFieldsParamsHierarchyDeductionFeedRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateHierarchyDeductionFeedProcessExecutor extends SupplierProcessExecutor<UpdateHierarchyDeductionFeedProcess, HierarchyDeductionFeed> {

    public UpdateHierarchyDeductionFeedProcessExecutor() {
        super(new UpdateHierarchyDeductionFeedProcess(),
                UpdateFieldsParamsHierarchyDeductionFeedRule::new,
                UpdateHierarchyDeductionFeedRule::new
        );
    }

    public static UpdateHierarchyDeductionFeedProcessExecutor builder() {
        return new UpdateHierarchyDeductionFeedProcessExecutor();
    }

}
