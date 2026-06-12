package com.personal.business.user.filter.process;

import com.personal.business.user.entities.User;
import com.personal.business.user.filter.inputs.FilterUserInput;
import com.personal.business.user.filter.process.rules.FilterUserRule;
import com.personal.business.user.filter.process.rules.UserEmailFilterRule;
import com.personal.business.user.filter.process.rules.UserIdFilterRule;
import com.personal.business.user.filter.process.rules.UserNameFilterRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterUserProcessExecutor extends FunctionalProcessExecutor<FilterUserProcess, FilterUserInput, User> {

    public FilterUserProcessExecutor() {
        super(new FilterUserProcess(),
                UserIdFilterRule::new,
                UserEmailFilterRule::new,
                UserNameFilterRule::new,
                FilterUserRule::new
        );
    }

    public static FilterUserProcessExecutor builder() {
        return new FilterUserProcessExecutor();
    }

}
