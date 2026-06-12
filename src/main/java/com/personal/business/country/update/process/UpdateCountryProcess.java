package com.personal.business.country.update.process;

import com.personal.backoffice.country.entities.Country;
import com.personal.shared.process.SupplierProcess;

public class UpdateCountryProcess extends SupplierProcess<Country> {

    public UpdateCountryProcess() {
        super("update_country_process");
    }

}
