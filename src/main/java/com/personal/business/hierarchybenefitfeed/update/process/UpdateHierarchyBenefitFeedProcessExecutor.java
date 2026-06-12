package com.personal.business.hierarchybenefitfeed.update.process;

import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;
import com.personal.business.hierarchybenefitfeed.update.process.rules.UpdateHierarchyBenefitFeedRule;
import com.personal.business.hierarchybenefitfeed.update.process.rules.UpdateFieldsParamsHierarchyBenefitFeedRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateHierarchyBenefitFeedProcessExecutor extends SupplierProcessExecutor<UpdateHierarchyBenefitFeedProcess, HierarchyBenefitFeed> {

    public UpdateHierarchyBenefitFeedProcessExecutor() {
        super(new UpdateHierarchyBenefitFeedProcess(),
                UpdateFieldsParamsHierarchyBenefitFeedRule::new,
                UpdateHierarchyBenefitFeedRule::new
        );
    }

    public static UpdateHierarchyBenefitFeedProcessExecutor builder() {
        return new UpdateHierarchyBenefitFeedProcessExecutor();
    }

}
