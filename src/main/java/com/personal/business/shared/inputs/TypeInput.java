package com.personal.business.shared.inputs;

import com.personal.backoffice.business.entities.Business;
import com.personal.business.shared.entities.TypeEntity;
import com.personal.shared.inputs.BaseTypeInput;

public class TypeInput extends BaseTypeInput {

    private String businessId;

    public String getBusinessId() {
        return businessId;
    }

    @Override
    public TypeEntity getType() {
        var userType = this.id == null || this.id.isEmpty() ? new TypeEntity() : new TypeEntity(this.id);
        var business = new Business(this.businessId);
        userType.setType(this.type);
        userType.setTitle(this.title);
        userType.setDescription(this.description);
        userType.setBusiness(business);
        userType.setCreatedBy(this.sessionUser);
        return userType;

    }

}
