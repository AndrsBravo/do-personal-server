package com.personal.backoffice.system.appdata.process.systemdata.rules;

import java.util.stream.Stream;

import com.personal.backoffice.country.create.process.CreateCountryProcessExecutor;
import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.system.appdata.process.systemdata.SystemDataProcess;
import com.personal.server.mapper.JsonMapper;
import com.personal.shared.process.IProcessRule;

public class SystemDataCountryRule implements IProcessRule<SystemDataProcess> {

    @Override
    public void apply(SystemDataProcess process) {

        var data = process.getInitObject();
        if (data.isEmpty()) {
        }
        var countriesJson = data.get("countries");

        if (countriesJson == null) {
        }

        var countries = JsonMapper.fromJson(countriesJson, Country[].class);
        if (countries == null || countries.length < 1) {
        }

        Stream.of(countries).forEach(country -> CreateCountryProcessExecutor.builder().init(country).execute().getLogs().forEach(process::addLog));

    }

}
