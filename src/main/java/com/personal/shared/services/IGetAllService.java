package com.personal.shared.services;

import java.util.List;

import com.personal.shared.entities.BaseEntity;

public interface IGetAllService<T extends BaseEntity> {

    public ServiceResult<List<T>> getAll();

}
