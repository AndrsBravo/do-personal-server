package com.personal.backoffice.api;

import com.personal.backoffice.business.api.routers.BusinessRouter;
import com.personal.backoffice.client.api.routers.ClientsRouter;
import com.personal.backoffice.clienttype.api.routers.ClientTypesRouter;
import com.personal.backoffice.commercial.entity.api.routers.CommercialEntityRouter;
import com.personal.backoffice.commercial.plan.api.routers.CommercialPlanRouter;
import com.personal.backoffice.commercial.plandetail.api.routers.CommercialPlanDetailRouter;
import com.personal.backoffice.country.api.routers.CountryRouter;
import com.personal.backoffice.register.api.routers.UserRegisterRouter;
import com.personal.backoffice.user.api.routers.UserRouter;
import com.personal.backoffice.userrelation.api.routers.UserRelationsRouter;
import com.personal.backoffice.userrole.api.routers.UserRolesRouter;
import com.personal.backoffice.usertype.api.routers.UserTypesRouter;

import io.helidon.http.Status;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class BackOfficeRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules
                .register("/business", new BusinessRouter())
                .register("/clients", new ClientsRouter())
                .register("/client_types", new ClientTypesRouter())
                .register("/commercial_plan", new CommercialPlanRouter())
                .register("/commercial_plan_detail", new CommercialPlanDetailRouter())
                .register("/commercial_entity", new CommercialEntityRouter())
                .register("/countries", new CountryRouter())
                .register("/register", new UserRegisterRouter())
                .register("/users", new UserRouter())
                .register("/user_relation", new UserRelationsRouter())
                .register("/user_role", new UserRolesRouter())
                .register("/user_types", new UserTypesRouter())
                .get((req, res) -> {

                    res.status(Status.OK_200).send("Hola desde al BackOffice Router");

                });

    }
}
