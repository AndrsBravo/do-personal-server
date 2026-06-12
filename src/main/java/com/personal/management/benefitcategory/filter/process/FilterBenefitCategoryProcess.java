package com.personal.management.benefitcategory.filter.process;

import com.personal.management.benefitcategory.entities.BenefitCategory;
import com.personal.management.benefitcategory.filter.inputs.FilterBenefitCategoryInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterBenefitCategoryProcess extends FunctionalProcess<FilterBenefitCategoryInput, BenefitCategory> {

    public FilterBenefitCategoryProcess() {
        super("filter_benefit_category_");
    }

}
