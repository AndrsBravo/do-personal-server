package com.personal.business.employee.filter.process;

import com.personal.business.employee.entities.Employee;
import com.personal.business.employee.filter.inputs.FilterEmployeeInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterEmployeeProcess extends FunctionalProcess<FilterEmployeeInput, Employee> {

    public FilterEmployeeProcess() {
        super("filter_employee_");
    }

}
