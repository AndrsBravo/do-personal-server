package com.personal.shared.factories;

import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

public class CreateService extends ServiceBase implements ICreateService {

    @Override
    public CreateResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto(this.tableName).Get();
        var result = CreateResultBuilder.build();
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
