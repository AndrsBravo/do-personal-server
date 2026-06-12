package com.personal.business.hierarchydeduction.update.services;

import java.util.Optional;

import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.business.hierarchydeduction.factories.HierarchyDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditHierarchyDeductionService implements IEditService<HierarchyDeduction> {

    private final Optional<DbClient> dbClient;

    public EditHierarchyDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<HierarchyDeduction> edit(Query query) {

        if (dbClient.isEmpty()) {
            return HierarchyDeductionResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("hierarchies_deductions").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return HierarchyDeductionResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return HierarchyDeductionResultFactory.UpdateFail();
        }

        return HierarchyDeductionResultFactory.UpdateSuccess(new HierarchyDeduction());

    }

}
