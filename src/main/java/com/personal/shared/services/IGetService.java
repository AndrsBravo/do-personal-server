package com.personal.shared.services;

import com.personal.shared.query.Query;
import com.personal.shared.services.entities.ServiceResult;

public interface IGetService<T> {

    public ServiceResult<T> get(Query query);

}
