package com.personal.backoffice.system.appdata.process.systemdata.rules;

import java.util.stream.Stream;

import com.personal.backoffice.clienttype.create.process.CreateClientTypeProcessExecutor;
import com.personal.backoffice.shared.entities.TypeEntity;
import com.personal.backoffice.system.appdata.process.systemdata.SystemDataProcess;
import com.personal.server.mapper.JsonMapper;
import com.personal.shared.process.IProcessRule;

public class SystemDataClientTypeRule implements IProcessRule<SystemDataProcess> {

    @Override
    public void apply(SystemDataProcess process) {

        var data = process.getInitObject();
        if (data.isEmpty()) {
        }
        var clientTypesJson = data.get("client_types");

        if (clientTypesJson == null) {
        }

        var clientTypes = JsonMapper.fromJson(clientTypesJson, TypeEntity[].class);
        if (clientTypes == null || clientTypes.length < 1) {
        }

        Stream.of(clientTypes).forEach(clientType -> CreateClientTypeProcessExecutor.builder().init(clientType).execute().getLogs().forEach(process::addLog));

    }

}
