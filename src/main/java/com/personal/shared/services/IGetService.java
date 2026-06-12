package com.personal.shared.services;

import com.personal.shared.query.Query;

public interface IGetService<T> {

    public ServiceResult<T> get(Query query);

}
