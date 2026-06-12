package com.personal.business.deductioncategory.filter.process;

import com.personal.business.deductioncategory.entities.DeductionCategory;
import com.personal.business.deductioncategory.filter.inputs.FilterDeductionCategoryInput;
import com.personal.business.deductioncategory.filter.process.rules.FilterDeductionCategoryRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterDeductionCategoryProcessExecutor extends FunctionalProcessExecutor<FilterDeductionCategoryProcess, FilterDeductionCategoryInput, DeductionCategory> {

    public FilterDeductionCategoryProcessExecutor() {
        super(new FilterDeductionCategoryProcess(), FilterDeductionCategoryRule::new);
    }

    public static FilterDeductionCategoryProcessExecutor builder() {
        return new FilterDeductionCategoryProcessExecutor();
    }

}
