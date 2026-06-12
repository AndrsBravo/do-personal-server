package com.personal.business.hierarchydeductionfeed.filter.process;

import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;
import com.personal.business.hierarchydeductionfeed.filter.inputs.FilterHierarchyDeductionFeedInput;
import com.personal.business.hierarchydeductionfeed.filter.process.rules.FilterHierarchyDeductionFeedRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterHierarchyDeductionFeedProcessExecutor extends FunctionalProcessExecutor<FilterHierarchyDeductionFeedProcess, FilterHierarchyDeductionFeedInput, HierarchyDeductionFeed> {

    public FilterHierarchyDeductionFeedProcessExecutor() {
        super(new FilterHierarchyDeductionFeedProcess(), FilterHierarchyDeductionFeedRule::new);
    }

    public static FilterHierarchyDeductionFeedProcessExecutor builder() {
        return new FilterHierarchyDeductionFeedProcessExecutor();
    }

}
