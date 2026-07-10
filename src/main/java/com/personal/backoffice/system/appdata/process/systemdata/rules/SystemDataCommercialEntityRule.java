package com.personal.backoffice.system.appdata.process.systemdata.rules;

import java.util.stream.Stream;

import com.personal.backoffice.commercial.entity.create.process.CreateCommercialEntityProcessExecutor;
import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.system.appdata.process.systemdata.SystemDataProcess;
import com.personal.server.mapper.JsonMapper;
import com.personal.shared.process.IProcessRule;

public class SystemDataCommercialEntityRule implements IProcessRule<SystemDataProcess> {

    @Override
    public void apply(SystemDataProcess process) {

        var data = process.getInitObject();
        if (data.isEmpty()) {
        }
        var entitiesJson = data.get("entities");

        if (entitiesJson == null) {
        }

        var entities = JsonMapper.fromJson(entitiesJson, CommercialEntity[].class);
        if (entities == null || entities.length < 1) {
        }

        Stream.of(entities).forEach(entity -> CreateCommercialEntityProcessExecutor.builder().init(entity).execute().getLogs().forEach(process::addLog));

    }

}
