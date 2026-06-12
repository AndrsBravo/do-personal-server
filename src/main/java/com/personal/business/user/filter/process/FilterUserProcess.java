package com.personal.business.user.filter.process;

import com.personal.business.user.entities.User;
import com.personal.business.user.filter.inputs.FilterUserInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterUserProcess extends FunctionalProcess<FilterUserInput, User> {

    public FilterUserProcess() {
        super("filter_user_process");
    }

}
