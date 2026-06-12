package com.personal.backoffice.country.create.process;

import com.personal.backoffice.country.create.process.rules.CreateCountryRule;
import com.personal.backoffice.country.create.process.rules.CreateManagementCountryRule;
import com.personal.backoffice.country.create.process.rules.ValidateCountryRule;
import com.personal.backoffice.country.entities.Country;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateCountryProcessExecutor extends SupplierProcessExecutor<CreateCountryProcess, Country> {

    public CreateCountryProcessExecutor() {
        super(new CreateCountryProcess(),
                ValidateCountryRule::new,
                CreateCountryRule::new,
                CreateManagementCountryRule::new
        );
    }

    public static CreateCountryProcessExecutor builder() {
        return new CreateCountryProcessExecutor();
    }

}
