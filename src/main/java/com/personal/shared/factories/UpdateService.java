package com.personal.shared.factories;

import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

public class UpdateService extends ServiceBase implements IEditService {

    @Override
    public ServiceResult edit(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update(this.tableName).Get();
        var result = ServiceResultBuilder.build();
        try {

            var records = dbclient.execute()
                    .createUpdate(updateQuery)
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
