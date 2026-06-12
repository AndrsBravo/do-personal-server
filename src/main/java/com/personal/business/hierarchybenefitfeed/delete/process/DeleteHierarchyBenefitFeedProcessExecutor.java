package com.personal.business.hierarchybenefitfeed.delete.process;

import com.personal.business.hierarchybenefitfeed.delete.process.rules.DeleteHierarchyBenefitFeedRule;
import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteHierarchyBenefitFeedProcessExecutor extends SupplierProcessExecutor<DeleteHierarchyBenefitFeedProcess, HierarchyBenefitFeed> {

    public DeleteHierarchyBenefitFeedProcessExecutor() {
        super(new DeleteHierarchyBenefitFeedProcess(),
                DeleteHierarchyBenefitFeedRule::new
        );
    }

    public static DeleteHierarchyBenefitFeedProcessExecutor builder() {
        return new DeleteHierarchyBenefitFeedProcessExecutor();
    }

}
