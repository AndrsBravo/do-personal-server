package com.personal.backoffice.business.process.delete;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.process.SupplierProcess;

public class DeleteBusinessProcess extends SupplierProcess<Business> {

    public DeleteBusinessProcess() {
        super("delete_business_process");
    }

}
