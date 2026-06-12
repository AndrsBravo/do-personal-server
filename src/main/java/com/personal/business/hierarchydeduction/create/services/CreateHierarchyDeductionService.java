package com.personal.business.hierarchydeduction.create.services;

import java.util.Optional;

import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.business.hierarchydeduction.factories.HierarchyDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateHierarchyDeductionService implements ICreateService<HierarchyDeduction> {

    private final Optional<DbClient> dbClient;

    public CreateHierarchyDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<HierarchyDeduction> create(Query query) {
        if (dbClient.isEmpty()) {
            return HierarchyDeductionResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("hierarchies_deductions").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return HierarchyDeductionResultFactory.CreateFail();
        }

        if (result == 0) {
            return HierarchyDeductionResultFactory.CreateFail();
        }

        return HierarchyDeductionResultFactory.CreateSuccess(new HierarchyDeduction());

    }

}
