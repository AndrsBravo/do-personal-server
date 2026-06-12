package com.personal.business.payrollrunresult.entities;

import com.personal.business.payroll.entities.Payroll;
import com.personal.shared.entities.BusinessEntity;

public class PayrollRunResult extends BusinessEntity {

    private String title;
    private Payroll payroll;
    private String description;
    private String referenceId;
    private String referenceTitle;
    private Double quantity;

    public PayrollRunResult() {
        super();
    }

    public PayrollRunResult(String id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return referenceId;
    }

    public void setReference(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getReferenceTitle() {
        return referenceTitle;
    }

    public void setReferenceTitle(String referenceTitle) {
        this.referenceTitle = referenceTitle;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

}
