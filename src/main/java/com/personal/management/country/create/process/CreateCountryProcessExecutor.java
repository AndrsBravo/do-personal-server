package com.personal.management.country.create.process;

import com.personal.management.country.create.process.rules.CreateCountryRule;
import com.personal.management.country.create.process.rules.ValidateCountryRule;
import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateCountryProcessExecutor extends SupplierProcessExecutor<CreateCountryProcess, SharedCountry> {

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
