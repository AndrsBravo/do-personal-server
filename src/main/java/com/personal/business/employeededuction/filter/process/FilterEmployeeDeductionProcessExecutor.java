package com.personal.business.employeededuction.filter.process;

import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.business.employeededuction.filter.inputs.FilterEmployeeDeductionInput;
import com.personal.business.employeededuction.filter.process.rules.FilterEmployeeDeductionRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterEmployeeDeductionProcessExecutor extends FunctionalProcessExecutor<FilterEmployeeDeductionProcess, FilterEmployeeDeductionInput, EmployeeDeduction> {

    public FilterEmployeeDeductionProcessExecutor() {
        super(new FilterEmployeeDeductionProcess(), FilterEmployeeDeductionRule::new);
    }

    public static FilterEmployeeDeductionProcessExecutor builder() {
        return new FilterEmployeeDeductionProcessExecutor();
    }

}
