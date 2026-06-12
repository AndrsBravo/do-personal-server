package com.personal.backoffice.user.associatebusiness.add.inputs;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.entities.UserRelation;
import com.personal.backoffice.user.entities.UserRole;
import com.personal.shared.inputs.Input;

public class AssociateUserBusinessInput extends Input {

    private String userId;
    private String businessId;
    private String userRoleId;
    private String userRelationId;

    public AssociateUserBusinessInput() {
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

    public AssociateUserBusiness toAssociateUserBusiness() {
        var associateUserBusiness = this.id == null ? new AssociateUserBusiness() : new AssociateUserBusiness(this.getId());
        associateUserBusiness.setBusiness(new Business(this.getBusinessId()));
        associateUserBusiness.setUser(new User(this.getUserId()));
        associateUserBusiness.setUserRole(new UserRole(this.getUserRoleId()));
        associateUserBusiness.setUserRelation(new UserRelation(this.getUserRelationId()));
        associateUserBusiness.setCreatedBy(this.sessionUser);
        return associateUserBusiness;
    }
}
