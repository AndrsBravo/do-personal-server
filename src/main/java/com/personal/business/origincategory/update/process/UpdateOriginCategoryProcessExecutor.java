package com.personal.business.origincategory.update.process;

import com.personal.business.origincategory.entities.OriginCategory;
import com.personal.business.origincategory.update.process.rules.UpdateFieldsParamsOriginCategoryRule;
import com.personal.business.origincategory.update.process.rules.UpdateOriginCategoryRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateOriginCategoryProcessExecutor extends SupplierProcessExecutor<UpdateOriginCategoryProcess, OriginCategory> {

    public UpdateOriginCategoryProcessExecutor() {
        super(new UpdateOriginCategoryProcess(),
                UpdateFieldsParamsOriginCategoryRule::new,
                UpdateOriginCategoryRule::new
        );
    }

    public static UpdateOriginCategoryProcessExecutor builder() {
        return new UpdateOriginCategoryProcessExecutor();
    }

}
