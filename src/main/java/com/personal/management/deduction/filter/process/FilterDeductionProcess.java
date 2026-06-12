package com.personal.management.deduction.filter.process;

import com.personal.management.deduction.entities.Deduction;
import com.personal.management.deduction.filter.inputs.FilterDeductionInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterDeductionProcess extends FunctionalProcess<FilterDeductionInput, Deduction> {

    public FilterDeductionProcess() {
        super("filter_deduction_");
    }

}
