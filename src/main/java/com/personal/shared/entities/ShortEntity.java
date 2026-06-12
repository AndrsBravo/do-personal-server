package com.personal.shared.entities;

import com.personal.shared.utils.Identity;

public abstract class ShortEntity extends Base {

    public ShortEntity() {
        super(Identity.shortUUID());
    }

    public ShortEntity(String id) {
        super(id);
    }

}
