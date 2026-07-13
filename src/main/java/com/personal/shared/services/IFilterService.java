package com.personal.shared.services;

import com.personal.shared.entities.Base;
import com.personal.shared.query.Query;
import com.personal.shared.services.entities.FetchResult;

public interface IFilterService<T extends Base> {

    public FetchResult<T> filter(Query filterQuery);

}
