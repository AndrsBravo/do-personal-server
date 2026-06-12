package com.personal.management.financecategory.update.process;

import com.personal.management.financecategory.entities.FinanceCategory;
import com.personal.management.financecategory.update.process.rules.UpdateFieldsParamsFinanceCategoryRule;
import com.personal.management.financecategory.update.process.rules.UpdateFinanceCategoryRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateFinanceCategoryProcessExecutor extends SupplierProcessExecutor<UpdateFinanceCategoryProcess, FinanceCategory> {

    public UpdateFinanceCategoryProcessExecutor() {
        super(new UpdateFinanceCategoryProcess(),
                UpdateFieldsParamsFinanceCategoryRule::new,
                UpdateFinanceCategoryRule::new
        );
    }

    public static UpdateFinanceCategoryProcessExecutor builder() {
        return new UpdateFinanceCategoryProcessExecutor();
    }

}
