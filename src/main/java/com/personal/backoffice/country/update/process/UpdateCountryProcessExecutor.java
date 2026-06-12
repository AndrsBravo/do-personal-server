package com.personal.backoffice.country.update.process;

import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.country.update.process.rules.UpdateCountryRule;
import com.personal.backoffice.country.update.process.rules.UpdateFieldsParamsCountriesRule;
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
