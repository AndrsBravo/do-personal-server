package com.personal.shared.factories;

import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

public class CreateService extends ServiceBase implements ICreateService {

    @Override
    public ServiceResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto(this.tableName).Get();
        var result = ServiceResultBuilder.build();
        try {

            var records = dbclient.execute()
                    .createInsert(insertQuery)
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
