package com.personal.business.structure.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.business.orgstructure.entities.OrgStructure;
import com.personal.shared.core.entities.SharedOrgStructure;

public class Structure extends SharedOrgStructure {

    private Business business;
    private OrgStructure orgStructure;
    private Structure parent;

    public Structure() {
        super();
    }

    public Structure(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public OrgStructure getOrgStructure() {
        return orgStructure;
    }

    public void setOrgStructure(OrgStructure orgStructure) {
        this.orgStructure = orgStructure;
    }

    public Structure getParent() {
        return parent;
    }

    public void setParent(Structure parent) {
        this.parent = parent;
    }

}
