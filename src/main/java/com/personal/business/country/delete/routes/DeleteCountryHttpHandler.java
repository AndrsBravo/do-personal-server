package com.personal.business.country.delete.routes;

import com.personal.business.country.delete.process.DeleteCountryProcessExecutor;
import com.personal.backoffice.country.entities.Country;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteCountryHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var country = new Country(id);

        var deleteCountry = DeleteCountryProcessExecutor.builder()
                .init(country)
                .execute();

        if (deleteCountry.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(deleteCountry.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(deleteCountry.getInitObject());
    }

}
