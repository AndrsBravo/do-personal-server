package com.personal.shared.factories;

import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

public class DeleteService extends ServiceBase implements IDeleteService {

    @Override
    public CreateResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete(this.tableName).Get();
        var result = CreateResultBuilder.build();
        try {

            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();
            result.withRecords(records)
                    .withNotification(this.successNotification);
        } catch (Exception e) {

            result.withException(e)
                    .withNotification(this.failureNotification);
        }
        return result.get();
    }

}
