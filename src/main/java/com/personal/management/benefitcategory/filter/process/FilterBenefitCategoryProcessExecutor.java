package com.personal.management.benefitcategory.filter.process;

import com.personal.management.benefitcategory.entities.BenefitCategory;
import com.personal.management.benefitcategory.filter.inputs.FilterBenefitCategoryInput;
import com.personal.management.benefitcategory.filter.process.rules.FilterBenefitCategoryRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterBenefitCategoryProcessExecutor extends FunctionalProcessExecutor<FilterBenefitCategoryProcess, FilterBenefitCategoryInput, BenefitCategory> {

    public FilterBenefitCategoryProcessExecutor() {
        super(new FilterBenefitCategoryProcess(), FilterBenefitCategoryRule::new);
    }

    public static FilterBenefitCategoryProcessExecutor builder() {
        return new FilterBenefitCategoryProcessExecutor();
    }

}
