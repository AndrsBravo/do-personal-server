package com.personal.management.country.delete.process;

import com.personal.management.country.delete.process.rules.DeleteCountryRule;
import com.personal.management.country.entities.Country;
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
