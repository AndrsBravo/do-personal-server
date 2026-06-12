package com.personal.business.hierarchydeductionfeed.delete.process;

import com.personal.business.hierarchydeductionfeed.delete.process.rules.DeleteHierarchyDeductionFeedRule;
import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteHierarchyDeductionFeedProcessExecutor extends SupplierProcessExecutor<DeleteHierarchyDeductionFeedProcess, HierarchyDeductionFeed> {

    public DeleteHierarchyDeductionFeedProcessExecutor() {
        super(new DeleteHierarchyDeductionFeedProcess(),
                DeleteHierarchyDeductionFeedRule::new
        );
    }

    public static DeleteHierarchyDeductionFeedProcessExecutor builder() {
        return new DeleteHierarchyDeductionFeedProcessExecutor();
    }

}
