package com.personal.business.employeedeductionfeed.filter.process;

import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.business.employeedeductionfeed.filter.inputs.FilterEmployeeDeductionFeedInput;
import com.personal.business.employeedeductionfeed.filter.process.rules.FilterEmployeeDeductionFeedRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterEmployeeDeductionFeedProcessExecutor extends FunctionalProcessExecutor<FilterEmployeeDeductionFeedProcess, FilterEmployeeDeductionFeedInput, EmployeeDeductionFeed> {

    public FilterEmployeeDeductionFeedProcessExecutor() {
        super(new FilterEmployeeDeductionFeedProcess(), FilterEmployeeDeductionFeedRule::new);
    }

    public static FilterEmployeeDeductionFeedProcessExecutor builder() {
        return new FilterEmployeeDeductionFeedProcessExecutor();
    }

}
