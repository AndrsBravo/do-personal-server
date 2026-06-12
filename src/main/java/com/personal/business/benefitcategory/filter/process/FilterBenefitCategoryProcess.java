package com.personal.business.benefitcategory.filter.process;

import com.personal.business.benefitcategory.entities.BenefitCategory;
import com.personal.business.benefitcategory.filter.inputs.FilterBenefitCategoryInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterBenefitCategoryProcess extends FunctionalProcess<FilterBenefitCategoryInput, BenefitCategory> {

    public FilterBenefitCategoryProcess() {
        super("filter_benefit_category_");
    }

}
