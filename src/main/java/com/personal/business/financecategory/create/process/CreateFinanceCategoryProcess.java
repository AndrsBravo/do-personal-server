package com.personal.business.financecategory.create.process;

import com.personal.business.financecategory.entities.FinanceCategory;
import com.personal.shared.process.SupplierProcess;

public class CreateFinanceCategoryProcess extends SupplierProcess<FinanceCategory> {

    public CreateFinanceCategoryProcess() {
        super("create_finance_category_process");
    }

}
