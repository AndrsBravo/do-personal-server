package com.personal.business.country.delete.process;

import com.personal.business.country.delete.process.rules.DeleteCountryRule;
import com.personal.backoffice.country.entities.Country;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteCountryProcessExecutor extends SupplierProcessExecutor<DeleteCountryProcess, Country> {

    public DeleteCountryProcessExecutor() {
        super(new DeleteCountryProcess(),
                DeleteCountryRule::new
        );
    }

    public static DeleteCountryProcessExecutor builder() {
        return new DeleteCountryProcessExecutor();
    }

}
