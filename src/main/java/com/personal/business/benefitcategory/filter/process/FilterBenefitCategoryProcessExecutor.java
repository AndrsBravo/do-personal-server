package com.personal.business.benefitcategory.filter.process;

import com.personal.business.benefitcategory.entities.BenefitCategory;
import com.personal.business.benefitcategory.filter.inputs.FilterBenefitCategoryInput;
import com.personal.business.benefitcategory.filter.process.rules.FilterBenefitCategoryRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterBenefitCategoryProcessExecutor extends FunctionalProcessExecutor<FilterBenefitCategoryProcess, FilterBenefitCategoryInput, BenefitCategory> {

    public FilterBenefitCategoryProcessExecutor() {
        super(new FilterBenefitCategoryProcess(), FilterBenefitCategoryRule::new);
    }

    public static FilterBenefitCategoryProcessExecutor builder() {
        return new FilterBenefitCategoryProcessExecutor();
    }

}
