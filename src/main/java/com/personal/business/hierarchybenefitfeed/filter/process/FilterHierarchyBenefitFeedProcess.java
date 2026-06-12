package com.personal.business.hierarchybenefitfeed.filter.process;

import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;
import com.personal.business.hierarchybenefitfeed.filter.inputs.FilterHierarchyBenefitFeedInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterHierarchyBenefitFeedProcess extends FunctionalProcess<FilterHierarchyBenefitFeedInput, HierarchyBenefitFeed> {

    public FilterHierarchyBenefitFeedProcess() {
        super("filter_hierarchy_benefit_feed_process");
    }

}
