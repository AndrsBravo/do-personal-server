package com.personal.backoffice.register.api.routers;

import com.personal.backoffice.register.login.routes.LoginHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class UserRegisterRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {

        rules.post("/login", new LoginHttpHandler()::Post);
    }

}
