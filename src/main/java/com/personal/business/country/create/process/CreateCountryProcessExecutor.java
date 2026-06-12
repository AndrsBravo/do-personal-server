package com.personal.business.country.create.process;

import com.personal.business.country.create.process.rules.CreateCountryRule;
import com.personal.business.country.create.process.rules.ValidateCountryRule;
import com.personal.backoffice.country.entities.Country;
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
