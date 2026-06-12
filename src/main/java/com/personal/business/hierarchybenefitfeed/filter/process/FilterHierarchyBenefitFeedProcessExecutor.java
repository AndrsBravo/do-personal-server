package com.personal.business.hierarchybenefitfeed.filter.process;

import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;
import com.personal.business.hierarchybenefitfeed.filter.inputs.FilterHierarchyBenefitFeedInput;
import com.personal.business.hierarchybenefitfeed.filter.process.rules.FilterHierarchyBenefitFeedRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterHierarchyBenefitFeedProcessExecutor extends FunctionalProcessExecutor<FilterHierarchyBenefitFeedProcess, FilterHierarchyBenefitFeedInput, HierarchyBenefitFeed> {

    public FilterHierarchyBenefitFeedProcessExecutor() {
        super(new FilterHierarchyBenefitFeedProcess(), FilterHierarchyBenefitFeedRule::new);
    }

    public static FilterHierarchyBenefitFeedProcessExecutor builder() {
        return new FilterHierarchyBenefitFeedProcessExecutor();
    }

}
