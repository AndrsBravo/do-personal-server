package com.personal.shared.services;

import com.personal.shared.entities.Base;
import com.personal.shared.query.Query;

public interface IEditService<T extends Base> {

    public ServiceResult<T> edit(Query updateQuery);
}
