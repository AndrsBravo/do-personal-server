package com.personal.business.employeebenefit.filter.process;

import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.business.employeebenefit.filter.inputs.FilterEmployeeBenefitInput;
import com.personal.business.employeebenefit.filter.process.rules.FilterEmployeeBenefitRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterEmployeeBenefitProcessExecutor extends FunctionalProcessExecutor<FilterEmployeeBenefitProcess, FilterEmployeeBenefitInput, EmployeeBenefit> {

    public FilterEmployeeBenefitProcessExecutor() {
        super(new FilterEmployeeBenefitProcess(), FilterEmployeeBenefitRule::new);
    }

    public static FilterEmployeeBenefitProcessExecutor builder() {
        return new FilterEmployeeBenefitProcessExecutor();
    }

}
