package com.personal.backoffice.userrole.filter.process;

import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.backoffice.userrole.filter.inputs.FilterUserRoleInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterUserRoleProcess extends FunctionalProcess<FilterUserRoleInput, UserRole> {

    public FilterUserRoleProcess() {
        super("filter_user_role");
    }

}
