package com.personal.backoffice.business.process.create;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.process.SupplierProcess;

public class CreateBusinessProcess extends SupplierProcess<Business> {

    public CreateBusinessProcess() {
        super("create_business_process");
    }

}
