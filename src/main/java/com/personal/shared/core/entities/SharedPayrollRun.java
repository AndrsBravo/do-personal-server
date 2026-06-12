package com.personal.shared.core.entities;

import com.personal.shared.entities.BaseEntity;
import com.personal.shared.entities.TypeEntityBase;

public class SharedPayrollRun extends BaseEntity {

    private String title;
    private String description;
    private SharedPayroll payroll;
    private TypeEntityBase payrollRunType;

    public SharedPayrollRun() {
        super();
    }

    public SharedPayrollRun(String id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SharedPayroll getPayroll() {
        return payroll;
    }

    public void setPayroll(SharedPayroll payroll) {
        this.payroll = payroll;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeEntityBase getPayrollRunType() {
        return payrollRunType;
    }

    public void setPayrollRunType(TypeEntityBase payrollRunType) {
        this.payrollRunType = payrollRunType;
    }

}
