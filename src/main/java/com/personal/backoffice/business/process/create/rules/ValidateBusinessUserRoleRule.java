package com.personal.backoffice.business.process.create.rules;

import com.personal.backoffice.business.process.create.CreateBusinessProcess;
import com.personal.backoffice.userrole.factories.UserRoleServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;
import com.personal.shared.query.Query;

public class ValidateBusinessUserRoleRule implements IProcessRule<CreateBusinessProcess> {

    @Override
    public void apply(CreateBusinessProcess process) {

        var pLogger = LogFactory.builder(CreateBusinessProcess.class, ValidateBusinessUserRoleRule.class);

        var query = new Query();

        query.Field("url_role", "admin");
        query.Where().Equ("url_role");

        var filteredUserRole = UserRoleServiceFactory.FilterUserRoles().filter(query);

        if (filteredUserRole.getResult() == null || filteredUserRole.getResult().isEmpty()) {
            process.addLog(pLogger.WARNING("Validar role de usuario", "No se ha podido validar el role de usuario"));
            process.stopWithErrors();
            return;

        }
        var userRole = filteredUserRole.getResult().getFirst();
        process.Query().Field("user_role_id", userRole.getId());
        process.addLog(pLogger.INFO("Validar role de usuario", "El role de usuario fue validada satisfactoriamente."));

    }

}
