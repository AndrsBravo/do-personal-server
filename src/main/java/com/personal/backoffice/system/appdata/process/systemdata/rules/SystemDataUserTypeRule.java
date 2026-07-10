package com.personal.backoffice.system.appdata.process.systemdata.rules;

import java.util.stream.Stream;

import com.personal.backoffice.shared.entities.TypeEntity;
import com.personal.backoffice.system.appdata.process.systemdata.SystemDataProcess;
import com.personal.backoffice.usertype.create.process.CreateUserTypeProcessExecutor;
import com.personal.server.mapper.JsonMapper;
import com.personal.shared.process.IProcessRule;

public class SystemDataUserTypeRule implements IProcessRule<SystemDataProcess> {

    @Override
    public void apply(SystemDataProcess process) {

        var data = process.getInitObject();
        if (data.isEmpty()) {
        }
        var userTypesJson = data.get("user_types");

        if (userTypesJson == null) {
        }

        var userTypes = JsonMapper.fromJson(userTypesJson, TypeEntity[].class);
        if (userTypes == null || userTypes.length < 1) {
        }

        Stream.of(userTypes).forEach(userType -> CreateUserTypeProcessExecutor.builder().init(userType).execute().getLogs().forEach(process::addLog));

    }

}
