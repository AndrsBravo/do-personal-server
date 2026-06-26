package com.personal.management.country.create.process;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.process.SupplierProcess;

public class CreateCountryProcess extends SupplierProcess<SharedCountry> {

    public CreateCountryProcess() {
        super("create_country_process");
    }

}
