package com.personal.business.employee.filter.process;

import com.personal.business.employee.entities.Employee;
import com.personal.business.employee.filter.inputs.FilterEmployeeInput;
import com.personal.business.employee.filter.process.rules.FilterEmployeeRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterEmployeeProcessExecutor extends FunctionalProcessExecutor<FilterEmployeeProcess, FilterEmployeeInput, Employee> {

    public FilterEmployeeProcessExecutor() {
        super(new FilterEmployeeProcess(), FilterEmployeeRule::new);
    }

    public static FilterEmployeeProcessExecutor builder() {
        return new FilterEmployeeProcessExecutor();
    }

}
