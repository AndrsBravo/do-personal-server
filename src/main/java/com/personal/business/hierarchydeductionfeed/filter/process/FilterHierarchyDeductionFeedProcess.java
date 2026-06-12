package com.personal.business.hierarchydeductionfeed.filter.process;

import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;
import com.personal.business.hierarchydeductionfeed.filter.inputs.FilterHierarchyDeductionFeedInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterHierarchyDeductionFeedProcess extends FunctionalProcess<FilterHierarchyDeductionFeedInput, HierarchyDeductionFeed> {

    public FilterHierarchyDeductionFeedProcess() {
        super("filter_hierarchy_deduction_feed_process");
    }

}
