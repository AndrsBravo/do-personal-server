package com.personal.management.origincategory.delete.routes;

import com.personal.management.origincategory.delete.process.DeleteOriginCategoryProcessExecutor;
import com.personal.management.origincategory.entities.OriginCategory;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteOriginCategoryHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var originCategory = new OriginCategory(id);

        var deleteOriginCategory = DeleteOriginCategoryProcessExecutor.builder()
                .init(originCategory)
                .execute();

        switch (deleteOriginCategory.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteOriginCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteOriginCategory.getInitObject());
        }
    }

}
