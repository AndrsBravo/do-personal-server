package com.personal.shared.services;

import java.util.List;

import com.personal.shared.entities.Base;
import com.personal.shared.query.Query;
import com.personal.shared.services.entities.ServiceResult;

public interface IFilterService<T extends Base> {

    public ServiceResult<List<T>> filter(Query filterQuery);

}
