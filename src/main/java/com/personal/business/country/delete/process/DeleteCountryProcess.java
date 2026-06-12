package com.personal.business.country.delete.process;

import com.personal.backoffice.country.entities.Country;
import com.personal.shared.process.SupplierProcess;

public class DeleteCountryProcess extends SupplierProcess<Country> {

    public DeleteCountryProcess() {
        super("delete_country_process");
    }

}
