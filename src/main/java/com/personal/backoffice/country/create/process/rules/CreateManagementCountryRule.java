package com.personal.backoffice.country.create.process.rules;

import com.personal.backoffice.country.create.process.CreateCountryProcess;
import com.personal.management.country.create.process.CreateCountryProcessExecutor;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateManagementCountryRule implements IProcessRule<CreateCountryProcess> {

    @Override
    public void apply(CreateCountryProcess process) {

        var pLogger = LogFactory.builder(CreateCountryProcess.class, CreateManagementCountryRule.class);

        var country = process.getInitObject();

        var createCountry = CreateCountryProcessExecutor.builder().init(country).execute();

        switch (createCountry.state()) {

            case COMPLETED -> {
                process.addLog(pLogger.INFO("Crear nuevo País", "País creado con éxito"));

            }
            case STOPPED, STOP_WITH_ERROR -> {
                process.addLog(createCountry.getCurrentLog());
                process.stopWithErrors();
            }
        }

    }

}
