package com.personal.backoffice.user.associatebusiness.filter.inputs;

import com.personal.shared.inputs.FilterInput;

public class FilterAssociatedUserBusinessInput extends FilterInput {

    private String userId;
    private String businessId;
    private String userRoleId;
    private String userRelationId;

    public FilterAssociatedUserBusinessInput() {
        super();
    }

    public void setBusinessId(String clientTypeId) {
        this.businessId = clientTypeId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRelationId(String userRelationId) {
        this.userRelationId = userRelationId;
    }

    public String getUserRelationId() {
        return userRelationId;
    }

}
