package com.personal.business.deduction.filter.process;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.deduction.filter.inputs.FilterDeductionInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterDeductionProcess extends FunctionalProcess<FilterDeductionInput, Deduction> {

    public FilterDeductionProcess() {
        super("filter_deduction_");
    }

}
