package com.personal.shared.services;

import com.personal.shared.query.Query;
import com.personal.shared.services.entities.GetResult;

public interface IGetService<T> {

    public GetResult<T> get(Query query);

}
