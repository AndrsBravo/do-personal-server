package com.personal.business.employeescale.filter.process;

import com.personal.business.employeescale.entities.EmployeeScale;
import com.personal.business.employeescale.filter.inputs.FilterEmployeeScaleInput;
import com.personal.business.employeescale.filter.process.rules.FilterEmployeeScaleRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterEmployeeScaleProcessExecutor extends FunctionalProcessExecutor<FilterEmployeeScaleProcess, FilterEmployeeScaleInput, EmployeeScale> {

    public FilterEmployeeScaleProcessExecutor() {
        super(new FilterEmployeeScaleProcess(), FilterEmployeeScaleRule::new);
    }

    public static FilterEmployeeScaleProcessExecutor builder() {
        return new FilterEmployeeScaleProcessExecutor();
    }

}
