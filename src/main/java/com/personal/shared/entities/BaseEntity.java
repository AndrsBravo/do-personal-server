package com.personal.shared.entities;

import com.personal.shared.utils.Identity;

public abstract class BaseEntity extends Base {

    public BaseEntity() {
        super(Identity.midUUID());
    }

    public BaseEntity(String id) {
        super(id);
    }

}
