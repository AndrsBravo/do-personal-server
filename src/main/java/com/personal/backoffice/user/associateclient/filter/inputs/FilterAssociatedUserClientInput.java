package com.personal.backoffice.user.associateclient.filter.inputs;

import com.personal.shared.inputs.FilterInput;

public class FilterAssociatedUserClientInput extends FilterInput {

    private String userId;
    private String clientId;
    private String userRoleId;
    private String userRelationId;

    public FilterAssociatedUserClientInput() {
        super();
    }

    public void setClientId(String clientTypeId) {
        this.clientId = clientTypeId;
    }

    public String getClientId() {
        return clientId;
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
