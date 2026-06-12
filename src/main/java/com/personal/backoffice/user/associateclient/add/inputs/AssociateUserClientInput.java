package com.personal.backoffice.user.associateclient.add.inputs;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.entities.UserRelation;
import com.personal.backoffice.user.entities.UserRole;
import com.personal.shared.inputs.Input;

public class AssociateUserClientInput extends Input {

    private String userId;
    private String clientId;
    private String userRoleId;
    private String userRelationId;

    public AssociateUserClientInput() {
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

    public AssociateUserClient toAssociateUserClient() {
        var associateUserClient = this.id == null ? new AssociateUserClient() : new AssociateUserClient(this.getId());
        associateUserClient.setClient(new Client(this.getClientId()));
        associateUserClient.setUser(new User(this.getUserId()));
        associateUserClient.setUserRole(new UserRole(this.getUserRoleId()));
        associateUserClient.setUserRelation(new UserRelation(this.getUserRelationId()));
        associateUserClient.setCreatedBy(this.sessionUser);
        return associateUserClient;
    }
}
