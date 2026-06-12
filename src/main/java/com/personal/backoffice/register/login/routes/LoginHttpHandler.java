package com.personal.backoffice.register.login.routes;

import com.personal.backoffice.register.login.inputs.LoginInput;
import com.personal.backoffice.register.login.process.LoginProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class LoginHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var user = request.content().as(LoginInput.class);
        var processExecutor = LoginProcessExecutor.builder().init(user.getUser()).execute();

        if (processExecutor.state() == ProcessState.COMPLETED) {
            response.status(200).send("Login successful");
            return;
        }
        response.status(401).send("Login failed");
    }

}
