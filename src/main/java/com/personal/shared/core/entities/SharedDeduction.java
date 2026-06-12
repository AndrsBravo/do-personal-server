package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

public class SharedDeduction extends ShortEntity {

    private String title;
    private String deduction;
    private String description;
    private SharedDeductionCategory accountantType;
    private SharedOriginCategory changeOriginType;

    public SharedDeduction() {
        super();
    }

    public SharedDeduction(String id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeduction() {
        return deduction;
    }

    public void setDeduction(String deduction) {
        this.deduction = deduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SharedDeductionCategory getAccountantType() {
        return accountantType;
    }

    public void setAccountantType(SharedDeductionCategory accountantType) {
        this.accountantType = accountantType;
    }

    public SharedOriginCategory getChangeOriginType() {
        return changeOriginType;
    }

    public void setChangeOriginType(SharedOriginCategory changeOriginType) {
        this.changeOriginType = changeOriginType;
    }

}
