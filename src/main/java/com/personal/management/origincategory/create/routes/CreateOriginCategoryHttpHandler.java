package com.personal.management.origincategory.create.routes;

import com.personal.management.origincategory.create.inputs.OriginCategoryInput;
import com.personal.management.origincategory.create.process.CreateOriginCategoryProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateOriginCategoryHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var originCategory = request.content().as(OriginCategoryInput.class);

        var createOriginCategory = CreateOriginCategoryProcessExecutor.builder()
                .init(originCategory.getOriginCategory())
                .execute();
        switch (createOriginCategory.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createOriginCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createOriginCategory.getInitObject());
        }
    }
}
