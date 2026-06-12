package com.personal.business.employeebenefit.filter.process;

import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.business.employeebenefit.filter.inputs.FilterEmployeeBenefitInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterEmployeeBenefitProcess extends FunctionalProcess<FilterEmployeeBenefitInput, EmployeeBenefit> {

    public FilterEmployeeBenefitProcess() {
        super("filter_employee_benefit_");
    }

}
