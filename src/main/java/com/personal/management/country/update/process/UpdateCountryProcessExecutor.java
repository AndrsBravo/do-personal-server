package com.personal.management.country.update.process;

import com.personal.management.country.entities.Country;
import com.personal.management.country.update.process.rules.UpdateCountryRule;
import com.personal.management.country.update.process.rules.UpdateFieldsParamsCountriesRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateCountryProcessExecutor extends SupplierProcessExecutor<UpdateCountryProcess, Country> {

    public UpdateCountryProcessExecutor() {
        super(new UpdateCountryProcess(),
                UpdateFieldsParamsCountriesRule::new,
                UpdateCountryRule::new
        );
    }

    public static UpdateCountryProcessExecutor builder() {
        return new UpdateCountryProcessExecutor();
    }

}
