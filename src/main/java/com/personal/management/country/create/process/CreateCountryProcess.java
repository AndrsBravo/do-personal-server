package com.personal.management.country.create.process;

import com.personal.management.country.entities.Country;
import com.personal.shared.process.SupplierProcess;

public class CreateCountryProcess extends SupplierProcess<Country> {

    public CreateCountryProcess() {
        super("create_country_process");
    }

}
