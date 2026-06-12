package com.personal.management.deductioncategory.filter.process;

import com.personal.management.deductioncategory.entities.DeductionCategory;
import com.personal.management.deductioncategory.filter.inputs.FilterDeductionCategoryInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterDeductionCategoryProcess extends FunctionalProcess<FilterDeductionCategoryInput, DeductionCategory> {

    public FilterDeductionCategoryProcess() {
        super("filter_deductions_category");
    }

}
