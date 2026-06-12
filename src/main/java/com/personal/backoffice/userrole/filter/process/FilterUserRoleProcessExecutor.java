package com.personal.backoffice.userrole.filter.process;

import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.backoffice.userrole.filter.inputs.FilterUserRoleInput;
import com.personal.backoffice.userrole.filter.process.rules.FilterUserRoleRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterUserRoleProcessExecutor extends FunctionalProcessExecutor<FilterUserRoleProcess, FilterUserRoleInput, UserRole> {

    public FilterUserRoleProcessExecutor() {
        super(new FilterUserRoleProcess(), FilterUserRoleRule::new);
    }

    public static FilterUserRoleProcessExecutor builder() {
        return new FilterUserRoleProcessExecutor();
    }

}
