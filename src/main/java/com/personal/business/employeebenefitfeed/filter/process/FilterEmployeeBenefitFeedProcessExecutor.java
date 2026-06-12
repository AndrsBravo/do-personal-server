package com.personal.business.employeebenefitfeed.filter.process;

import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;
import com.personal.business.employeebenefitfeed.filter.inputs.FilterEmployeeBenefitFeedInput;
import com.personal.business.employeebenefitfeed.filter.process.rules.FilterEmployeeBenefitFeedRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterEmployeeBenefitFeedProcessExecutor extends FunctionalProcessExecutor<FilterEmployeeBenefitFeedProcess, FilterEmployeeBenefitFeedInput, EmployeeBenefitFeed> {

    public FilterEmployeeBenefitFeedProcessExecutor() {
        super(new FilterEmployeeBenefitFeedProcess(), FilterEmployeeBenefitFeedRule::new);
    }

    public static FilterEmployeeBenefitFeedProcessExecutor builder() {
        return new FilterEmployeeBenefitFeedProcessExecutor();
    }

}
