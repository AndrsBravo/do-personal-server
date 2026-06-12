package com.personal.business.employeedeductionfeed.filter.process;

import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.business.employeedeductionfeed.filter.inputs.FilterEmployeeDeductionFeedInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterEmployeeDeductionFeedProcess extends FunctionalProcess<FilterEmployeeDeductionFeedInput, EmployeeDeductionFeed> {

    public FilterEmployeeDeductionFeedProcess() {
        super("filter_employee_deduction_feed_process");
    }

}
