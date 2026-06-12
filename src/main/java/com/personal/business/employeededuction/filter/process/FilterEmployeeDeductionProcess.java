package com.personal.business.employeededuction.filter.process;

import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.business.employeededuction.filter.inputs.FilterEmployeeDeductionInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterEmployeeDeductionProcess extends FunctionalProcess<FilterEmployeeDeductionInput, EmployeeDeduction> {

    public FilterEmployeeDeductionProcess() {
        super("filter_employee_deduction_");
    }

}
