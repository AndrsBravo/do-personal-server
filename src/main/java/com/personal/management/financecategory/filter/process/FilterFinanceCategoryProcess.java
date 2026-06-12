package com.personal.management.financecategory.filter.process;

import com.personal.management.financecategory.entities.FinanceCategory;
import com.personal.management.financecategory.filter.inputs.FilterFinanceCategoryInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterFinanceCategoryProcess extends FunctionalProcess<FilterFinanceCategoryInput, FinanceCategory> {

    public FilterFinanceCategoryProcess() {
        super("filter_finance_category");
    }

}
