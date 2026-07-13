package com.personal.shared.services;

import com.personal.shared.query.Query;
import com.personal.shared.services.entities.ServiceResult;

public interface IEditService {

    public ServiceResult edit(Query updateQuery);
}
