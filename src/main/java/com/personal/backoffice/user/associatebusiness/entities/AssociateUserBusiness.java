package com.personal.backoffice.user.associatebusiness.entities;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.shared.entities.BusinessEntity;

public class AssociateUserBusiness extends BusinessEntity {

    private User user;
    private UserRole userRole;
    private UserRelation userRelation;

    public AssociateUserBusiness() {
        super();
    }

    public AssociateUserBusiness(String id) {
        super(id);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserRelation getUserRelation() {
        return userRelation;
    }

    public void setUserRelation(UserRelation userRelation) {
        this.userRelation = userRelation;
    }
}
