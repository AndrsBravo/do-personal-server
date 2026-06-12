package com.personal.management.origincategory.delete.process;

import com.personal.management.origincategory.entities.OriginCategory;
import com.personal.shared.process.SupplierProcess;

public class DeleteOriginCategoryProcess extends SupplierProcess<OriginCategory> {

    public DeleteOriginCategoryProcess() {
        super("delete_origin_categories_process");
    }

}
