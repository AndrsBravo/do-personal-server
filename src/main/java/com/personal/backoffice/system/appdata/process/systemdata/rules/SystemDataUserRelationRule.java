package com.personal.backoffice.system.appdata.process.systemdata.rules;

import java.util.stream.Stream;

import com.personal.backoffice.system.appdata.process.systemdata.SystemDataProcess;
import com.personal.backoffice.userrelation.create.process.CreateUserRelationProcessExecutor;
import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.server.mapper.JsonMapper;
import com.personal.shared.process.IProcessRule;

public class SystemDataUserRelationRule implements IProcessRule<SystemDataProcess> {

    @Override
    public void apply(SystemDataProcess process) {

        var data = process.getInitObject();
        if (data.isEmpty()) {
        }
        var userRelationsJson = data.get("user_relations");

        if (userRelationsJson == null) {
        }

        var userRelations = JsonMapper.fromJson(userRelationsJson, UserRelation[].class);
        if (userRelations == null || userRelations.length < 1) {
        }

        Stream.of(userRelations).forEach(userRelation -> CreateUserRelationProcessExecutor.builder().init(userRelation).execute().getLogs().forEach(process::addLog));

    }

}
