package com.personal.backoffice.user.filter.process;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.filter.inputs.FilterUserInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterUserProcess extends FunctionalProcess<FilterUserInput, User> {

    public FilterUserProcess() {
        super("filter_user_process");
    }

}
