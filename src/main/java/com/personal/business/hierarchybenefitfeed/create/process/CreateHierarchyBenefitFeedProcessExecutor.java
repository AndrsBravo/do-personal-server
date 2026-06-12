package com.personal.business.hierarchybenefitfeed.create.process;

import com.personal.business.hierarchybenefitfeed.create.process.rules.CreateHierarchyBenefitFeedRule;
import com.personal.business.hierarchybenefitfeed.create.process.rules.ValidateHierarchyBenefitFeedRule;
import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateHierarchyBenefitFeedProcessExecutor extends SupplierProcessExecutor<CreateHierarchyBenefitFeedProcess, HierarchyBenefitFeed> {

    public CreateHierarchyBenefitFeedProcessExecutor() {
        super(new CreateHierarchyBenefitFeedProcess(),
                ValidateHierarchyBenefitFeedRule::new,
                CreateHierarchyBenefitFeedRule::new
        );
    }

    public static CreateHierarchyBenefitFeedProcessExecutor builder() {
        return new CreateHierarchyBenefitFeedProcessExecutor();
    }

}
