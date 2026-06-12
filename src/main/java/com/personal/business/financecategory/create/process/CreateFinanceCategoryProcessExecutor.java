package com.personal.business.financecategory.create.process;

import com.personal.business.financecategory.create.process.rules.CreateFinanceCategoryRule;
import com.personal.business.financecategory.create.process.rules.ValidateFinanceCategoryRule;
import com.personal.business.financecategory.entities.FinanceCategory;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateFinanceCategoryProcessExecutor extends SupplierProcessExecutor<CreateFinanceCategoryProcess, FinanceCategory> {

    public CreateFinanceCategoryProcessExecutor() {
        super(new CreateFinanceCategoryProcess(),
                ValidateFinanceCategoryRule::new,
                CreateFinanceCategoryRule::new
        );
    }

    public static CreateFinanceCategoryProcessExecutor builder() {
        return new CreateFinanceCategoryProcessExecutor();
    }

}
