package com.personal.business.employeebenefitfeed.filter.process;

import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;
import com.personal.business.employeebenefitfeed.filter.inputs.FilterEmployeeBenefitFeedInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterEmployeeBenefitFeedProcess extends FunctionalProcess<FilterEmployeeBenefitFeedInput, EmployeeBenefitFeed> {

    public FilterEmployeeBenefitFeedProcess() {
        super("filter_employee_benefit_feed_process");
    }

}
