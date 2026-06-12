package com.personal.business.origincategory.update.routes;

import com.personal.business.origincategory.create.inputs.OriginCategoryInput;
import com.personal.business.origincategory.update.process.UpdateOriginCategoryProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateOriginCategoryHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var originCategory = request.content().as(OriginCategoryInput.class);

        var updateOriginCategory = UpdateOriginCategoryProcessExecutor.builder()
                .init(originCategory.getOriginCategory())
                .execute();

        switch (updateOriginCategory.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateOriginCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateOriginCategory.getInitObject());
        }
    }

}
