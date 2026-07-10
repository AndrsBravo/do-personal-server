package com.personal.shared.services;

import com.personal.shared.query.Query;
import com.personal.shared.services.entities.CreateResult;

public interface IEditService {

    public CreateResult edit(Query updateQuery);
}
