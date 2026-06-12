package com.personal.business.financecategory.filter.process;

import com.personal.business.financecategory.entities.FinanceCategory;
import com.personal.business.financecategory.filter.inputs.FilterFinanceCategoryInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterFinanceCategoryProcess extends FunctionalProcess<FilterFinanceCategoryInput, FinanceCategory> {

    public FilterFinanceCategoryProcess() {
        super("filter_finance_category");
    }

}
