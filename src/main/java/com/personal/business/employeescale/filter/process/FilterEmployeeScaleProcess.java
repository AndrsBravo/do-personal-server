package com.personal.business.employeescale.filter.process;

import com.personal.business.employeescale.entities.EmployeeScale;
import com.personal.business.employeescale.filter.inputs.FilterEmployeeScaleInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterEmployeeScaleProcess extends FunctionalProcess<FilterEmployeeScaleInput, EmployeeScale> {

    public FilterEmployeeScaleProcess() {
        super("filter_employee_scale_process");
    }

}
