package com.personal.shared.services;

import java.util.List;

import com.personal.shared.entities.BaseEntity;
import com.personal.shared.services.entities.ServiceResult;

public interface IGetAllService<T extends BaseEntity> {

    public ServiceResult<List<T>> getAll();

}
