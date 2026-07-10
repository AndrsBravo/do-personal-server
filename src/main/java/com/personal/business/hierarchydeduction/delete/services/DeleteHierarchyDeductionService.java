package com.personal.business.hierarchydeduction.delete.services;

import java.util.Optional;

import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.business.hierarchydeduction.factories.HierarchyDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteHierarchyDeductionService implements IDeleteService<HierarchyDeduction> {

    private final Optional<DbClient> dbClient;

    public DeleteHierarchyDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<HierarchyDeduction> delete(Query query) {
        if (dbClient.isEmpty()) {
            return HierarchyDeductionResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("hierarchies_deductions").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return HierarchyDeductionResultFactory.DeleteFail();
        }

        if (result == 0) {
            return HierarchyDeductionResultFactory.DeleteFail();
        }

        return HierarchyDeductionResultFactory.DeleteSuccess(new HierarchyDeduction(query.getParams().get("id")));

    }

}
