package com.personal.backoffice.system.appdata.process.systemdata.rules;

import java.util.stream.Stream;

import com.personal.backoffice.system.appdata.process.systemdata.SystemDataProcess;
import com.personal.backoffice.userrole.create.process.CreateUserRoleProcessExecutor;
import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.server.mapper.JsonMapper;
import com.personal.shared.process.IProcessRule;

public class SystemDataUserRoleRule implements IProcessRule<SystemDataProcess> {

    @Override
    public void apply(SystemDataProcess process) {

        var data = process.getInitObject();
        if (data.isEmpty()) {
        }
        var userRolesJson = data.get("user_roles");

        if (userRolesJson == null) {
        }

        var userRoles = JsonMapper.fromJson(userRolesJson, UserRole[].class);
        if (userRoles == null || userRoles.length < 1) {
        }

        Stream.of(userRoles).forEach(userRole -> CreateUserRoleProcessExecutor.builder().init(userRole).execute().getLogs().forEach(process::addLog));

    }

}
