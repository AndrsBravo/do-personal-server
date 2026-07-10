package com.personal.backoffice.country.create.process.rules;

import com.personal.backoffice.country.create.process.CreateCountryProcess;
import com.personal.backoffice.country.factories.CountryServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateCountryRule implements IProcessRule<CreateCountryProcess> {

    @Override
    public void apply(CreateCountryProcess process) {

        var pLogger = LogFactory.builder(CreateCountryProcess.class, CreateCountryRule.class);
        var createCountry = CountryServiceFactory.CreateCountry();
        var result = createCountry.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo País", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo País", "País Creado con éxito"));

    }

}
