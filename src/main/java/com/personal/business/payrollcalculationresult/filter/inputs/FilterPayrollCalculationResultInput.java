package com.personal.business.payrollcalculationresult.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterPayrollCalculationResultInput extends BusinessFilterInputBase {

    private String title;
    private String payrollId;
    private String description;
    private String referenceId;
    private String referenceTitle;
    private Double quantity;

    public FilterPayrollCalculationResultInput() {
        super();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
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
