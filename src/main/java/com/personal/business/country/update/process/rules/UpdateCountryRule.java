package com.personal.business.country.update.process.rules;

import com.personal.business.country.factories.CountryServiceFactory;
import com.personal.business.country.update.process.UpdateCountryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateCountryRule implements IProcessRule<UpdateCountryProcess> {

    @Override
    public void apply(UpdateCountryProcess process) {

        var pLogger = LogFactory.builder(UpdateCountryProcess.class, UpdateCountryRule.class);
        var createCountry = CountryServiceFactory.EditCountry();
        var result = createCountry.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
