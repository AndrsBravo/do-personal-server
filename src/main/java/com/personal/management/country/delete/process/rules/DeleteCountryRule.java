package com.personal.management.country.delete.process.rules;

import com.personal.management.country.delete.process.DeleteCountryProcess;
import com.personal.management.country.factories.CountryServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteCountryRule implements IProcessRule<DeleteCountryProcess> {

    @Override
    public void apply(DeleteCountryProcess process) {

        var pLogger = LogFactory.builder(DeleteCountryProcess.class, DeleteCountryRule.class);

        var query = process.Query();
        var country = process.getInitObject();

        query.Field("id", country.getId());
        query.Where().Equ("id");

        var createCountry = CountryServiceFactory.DeleteCountry();
        var result = createCountry.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
