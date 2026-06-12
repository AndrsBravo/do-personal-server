package com.personal.management.country.create.process;

import com.personal.management.country.create.process.rules.CreateCountryRule;
import com.personal.management.country.create.process.rules.ValidateCountryRule;
import com.personal.management.country.entities.Country;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateCountryProcessExecutor extends SupplierProcessExecutor<CreateCountryProcess, Country> {

    public CreateCountryProcessExecutor() {
        super(new CreateCountryProcess(),
                ValidateCountryRule::new,
                CreateCountryRule::new
        );
    }

    public static CreateCountryProcessExecutor builder() {
        return new CreateCountryProcessExecutor();
    }

}
